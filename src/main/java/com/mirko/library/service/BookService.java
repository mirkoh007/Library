package com.mirko.library.service;

import com.mirko.library.model.Book;
import javassist.NotFoundException;

import java.util.List;

public interface BookService{

    /**
     * Returns all books from database
     *
     * @return returns all books from database
     */
    List<Book> findAll();

    /**
     * Returns book from database by given id of the book
     *
     * @param id - provided id to find book
     * @return - book by matching id
     */

    Book findById(Long id);

    /**
     * Delete book by given id
     *
     * @param id - provided id of book which will be deleted
     */

    void delete(Long id);

    /**
     * This option will add book into database
     *
     * @param newBook - new book that will be added into database
     * @return - book that is added into database
     */

    Book addBook(Book newBook);

    /**
     * Edit existing book in our database
     *
     * @param editedBook - book that will be edited
     * @return - edited book
     */

    Book editBook(Book editedBook);

    /**
     * Finds a book by title
     * @param title - title is search criteria
     * @return book if found
     * @throws NotFoundException - if there is no book by provided title
     */
    Book findByTitle(String title) throws NotFoundException;

}
