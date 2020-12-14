package com.mirko.library.service;

import com.mirko.library.model.ActiveBookRenting;
import com.mirko.library.model.Book;
import com.mirko.library.model.BookCopy;
import com.mirko.library.repository.ActiveBookRentingRepository;
import com.mirko.library.repository.BookCopyRepository;
import com.mirko.library.repository.BookRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;
    private final ActiveBookRentingRepository activeBookRentingRepository;


    public BookServiceImpl(BookRepository bookRepository, BookCopyRepository bookCopyRepository, ActiveBookRentingRepository activeBookRentingRepository) {
        this.bookRepository = bookRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.activeBookRentingRepository = activeBookRentingRepository;
    }

    /**
     * @return returns all books from database
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {

        List<ActiveBookRenting> isRented = activeBookRentingRepository.findByBookId(id);
        if(isRented.size() != 0){
           throw new IllegalArgumentException("Book with id: " + id +" has rented copies. Can't delete ");
        }

        List<BookCopy> hasCopiesOnStock = bookCopyRepository.findByBook_Id(id);
        if(hasCopiesOnStock.size() != 0){
            throw new IllegalArgumentException("Book with id: " + id + " has copies on stock. Please deal with them first");
        }

        bookRepository.deleteById(id);
    }

    @Override
    public Book addBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Book editBook(Book book) {
        Book editedBook = findById(book.getId());
        editedBook.setTitle(book.getTitle());
        editedBook.setAuthorName(book.getAuthorName());
        editedBook.setPublisher(book.getPublisher());
        editedBook.setDateOfPublishing(book.getDateOfPublishing());
        return bookRepository.save(editedBook);
    }

    @Override
    public Book findByTitle(String title) throws NotFoundException {
        Book foundedBook = bookRepository.findByTitle(title);

        if(foundedBook == null) {
            throw new NotFoundException("No such title");
        }
        return foundedBook;
    }

}
