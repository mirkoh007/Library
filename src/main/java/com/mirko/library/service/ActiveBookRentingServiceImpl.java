package com.mirko.library.service;

import com.mirko.library.dto.BookCopyIDsDTO;
import com.mirko.library.dto.BookCopyIDsToBookCopyIDsDTO;
import com.mirko.library.model.ActiveBookRenting;
import com.mirko.library.model.ArchiveOfRenting;
import com.mirko.library.model.Book;
import com.mirko.library.repository.ActiveBookRentingRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
@SuppressWarnings("Duplicates")
public class ActiveBookRentingServiceImpl implements ActiveBookRentingService{

    private static final Logger log = LoggerFactory.getLogger(ActiveBookRentingService.class);

    private final ActiveBookRentingRepository activeBookRentingRepository;
    private final UserService userService;
    private final BookCopyIDsToBookCopyIDsDTO bookCopyIDsToBookCopyIDsDTO;
    private final BookCopyService bookCopyService;
    private final BookService bookService;
    private final int maxDaysForRenting;
    private final ArchiveOfRentingService archiveOfRentingService;

    public ActiveBookRentingServiceImpl(ActiveBookRentingRepository activeBookRentingRepository,
                                        UserService userService,
                                        BookCopyIDsToBookCopyIDsDTO bookCopyIDsToBookCopyIDsDTO,
                                        BookCopyService bookCopyService,
                                        BookService bookService,
                                        @Value("${maxDaysForRenting}") int maxDaysForRenting, ArchiveOfRentingService archiveOfRentingService) {
        this.activeBookRentingRepository = activeBookRentingRepository;
        this.userService = userService;
        this.bookCopyIDsToBookCopyIDsDTO = bookCopyIDsToBookCopyIDsDTO;
        this.bookCopyService = bookCopyService;
        this.bookService = bookService;
        this.maxDaysForRenting = maxDaysForRenting;
        this.archiveOfRentingService = archiveOfRentingService;
    }

    public static class MyException extends Exception{
        public MyException(String message) {
            super(message);
        }
    }

    MyException overDueException = new MyException("Book is overdue");

    @Override
    public List<ActiveBookRenting> findAll() {
        return activeBookRentingRepository.findAll();
    }

    private List<ActiveBookRenting> findRentedCopiesForBook(Long id){
        return activeBookRentingRepository.findByBookId(id);
    }

    private List<BookCopyIDsDTO> findAllBookCopiesForBook(Long id){
        return  bookCopyIDsToBookCopyIDsDTO.convert(bookCopyService.findByBook_Id(id));
    }

    /**
     *
     * @param user_name user who is renting a book
     * @param book_id of book that user wants to rent
     * param freeBookCopyID is copy of the book user rents
     * @return user_id, book_id, book_copy_id, date_of_renting
     * @throws IllegalArgumentException user want to rent a book but there is no book-copies to rent
     */
    @Override
    public ActiveBookRenting save(String user_name, Long book_id) throws NotFoundException {

        Book doesBookExists = doesExists(book_id);

//      list of all rented copies for specific book by book id
        List<ActiveBookRenting> listOfRentedCopiesForBook = findRentedCopiesForBook(book_id);

//      all book-copies in database that belong to certain book
        List<BookCopyIDsDTO> listOfAllBookCopiesForBook = findAllBookCopiesForBook(book_id);

        if(listOfRentedCopiesForBook.size() == listOfAllBookCopiesForBook.size()) {
            log.info("Number of copies is equal to rented copies for book (book_id) " + book_id);
            throw new  NotFoundException("No free copies to rent book (book_id) " + book_id);
        }

//      create map fo get free book-copy copy to rent
        Map<Long, Long> freeBookCopiesToRent = freeBookCopies(listOfRentedCopiesForBook, listOfAllBookCopiesForBook);

        Long freeBookID = 0L;
        Long freeBookCopyID = 0L;

        for(Map.Entry<Long, Long> entry : freeBookCopiesToRent.entrySet()){
            freeBookCopyID = entry.getKey();
            freeBookID = entry.getValue();
            {
                if(freeBookCopyID !=0 && freeBookID !=0) {break;}
            }
        }

        Long user_id = userService.findByUserName(user_name.toLowerCase()).getId();

        ActiveBookRenting activeBookRenting = new ActiveBookRenting.Builder()
                .withUserID(user_id)
                .withBookID(freeBookID)
                .withBookCopyID(freeBookCopyID)
                .withDateOfRenting(LocalDate.now())
                .build();

        return activeBookRentingRepository.save(activeBookRenting);
    }

    @Override
    public List<ActiveBookRenting> findByBookId(Long id) throws  IllegalArgumentException {

        Book doesBookExists = doesExists(id);

//     list of all rented copies for specific book by book id
        List<ActiveBookRenting> listOfRentedCopiesForBook = findRentedCopiesForBook(id);

        if(listOfRentedCopiesForBook.size() == 0){
            log.info("There is no rented copies");
            throw new IllegalArgumentException("There is no rented book-copies for provided book: " + id);
        }

//      all book-copies in database that belong to certain book
//        List<BookCopyIDsDTO> listOfAllBookCopiesForBook = findAllBookCopiesForBook(id);

        return listOfRentedCopiesForBook;

    }

    @Override
    public ActiveBookRenting findByUserId(Long user_id)  {
        return activeBookRentingRepository.findByUserId(user_id);
    }

    @Override
    public List<ActiveBookRenting> findAllOverdueBooks(int maxDaysForRenting) {
        return activeBookRentingRepository.findAllOverdueBooks(maxDaysForRenting);
    }

    @Override
    public void deleteActiveBookRentingByUserIdAndBookCopyId(Long user_id, Long book_copy_id) throws MyException {
        ActiveBookRenting activeBookRenting = findByUserId(user_id);
        ArchiveOfRenting archive = new ArchiveOfRenting.Builder()
                .withUserId(activeBookRenting.getUserId())
                .withBookCopyId(activeBookRenting.getBookCopyId())
                .withBookId(activeBookRenting.getBookId())
                .withDateOfRenting(activeBookRenting.getDateOfRenting())
                .withDateOfReturning(LocalDate.now())
                .build();
        archiveOfRentingService.save(archive);

        LocalDate nowDate = LocalDate.now();
        LocalDate rentedDay = activeBookRentingRepository.findByUserId(user_id).getDateOfRenting();
        long isOverdue = DAYS.between(rentedDay,nowDate);
        if (isOverdue > maxDaysForRenting) {
            activeBookRentingRepository.deleteActiveBookRentingByUserIdAndBookCopyId(user_id, book_copy_id);
            throw overDueException;
        }
        activeBookRentingRepository.deleteActiveBookRentingByUserIdAndBookCopyId(user_id, book_copy_id);
    }

//  some helping methods

    private Map<Long, Long> freeBookCopies(List<ActiveBookRenting> listOfRentedCopiesForBook,
                                           List<BookCopyIDsDTO> listOfAllBookCopiesForBook){

        Map<Long, Long> mapOfRentedCopiesForBook = listOfRentedCopiesForBook.stream().collect(
                Collectors.toMap(ActiveBookRenting::getBookCopyId, ActiveBookRenting::getBookId));

        Map<Long, Long> mapOfAllBookCopiesForBook = listOfAllBookCopiesForBook.stream().collect(
                Collectors.toMap(BookCopyIDsDTO::getBookCopyID, BookCopyIDsDTO::getBookID));

        Map<Long, Long> resultMap = new HashMap<>();

        for(Map.Entry<Long, Long> entry : mapOfRentedCopiesForBook.entrySet()){
            if(!mapOfAllBookCopiesForBook.containsKey(entry.getKey())){
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }

        for(Map.Entry<Long, Long> entry : mapOfAllBookCopiesForBook.entrySet()){
            if(!mapOfRentedCopiesForBook.containsKey(entry.getKey())){
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }

        for(Map.Entry<Long, Long> entry : resultMap.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        return resultMap;

    }

    private Book doesExists(Long id) throws IllegalArgumentException{
        Book book =  bookService.findById(id);
        if(book == null) {
            throw new IllegalArgumentException("there is no such book");
        }

        return book;
    }

}
