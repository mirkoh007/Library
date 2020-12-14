package com.mirko.library.service;

import com.mirko.library.model.ActiveBookRenting;
import com.mirko.library.model.Book;
import com.mirko.library.model.BookCopy;
import com.mirko.library.repository.ActiveBookRentingRepository;
import com.mirko.library.repository.BookCopyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookService bookService;
    private final ActiveBookRentingRepository activeBookRentingRepository;


    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository,
                               BookService bookService, ActiveBookRentingRepository activeBookRentingRepository) {

        this.bookCopyRepository = bookCopyRepository;
        this.bookService = bookService;


        this.activeBookRentingRepository = activeBookRentingRepository;
    }
    @Override
    public List<BookCopy> finAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy findById(Long id) {
        return bookCopyRepository.getOne(id);
    }

    @Override
    public BookCopy saveBookCopy(Long id) {
        Book book = bookService.findById(id);
        BookCopy bookCopy = new BookCopy.Builder()
                .withSerial(UUID.randomUUID().toString())
                .withBook(book)
                .build();
        return bookCopyRepository.save(bookCopy);
    }

    @Override
    public void delete(Long id) throws IllegalArgumentException {
       ActiveBookRenting isRented =activeBookRentingRepository.findByBookCopyId(id);
        if(isRented != null) {
            throw new IllegalArgumentException("Book copy, with id: " + id + " is rented, can't delete!!");
        }
        bookCopyRepository.deleteById(id);
    }

    @Override
    public List<BookCopy> findByBook_Id(Long id) {
        return  bookCopyRepository.findByBook_Id(id);
    }


}
