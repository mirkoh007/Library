package com.mirko.library.service;

import com.mirko.library.model.ActiveBookRenting;
import javassist.NotFoundException;

import java.util.List;

public interface ActiveBookRentingService {

    /**
     * This option will return all books that are rented
     * @return all rented books
     */
    List<ActiveBookRenting> findAll();

    /**
     * This option will remove user and his/hers rented book-copy from database because user has returned a book
     * (a book-copy)
     * @param user_id - user who returns a book
     * @param book_copy_id - book-copy that she/he was renting by book-copy id
     * @throws ActiveBookRentingServiceImpl.MyException - warns if book has been overdue
     */
    void deleteActiveBookRentingByUserIdAndBookCopyId(Long user_id, Long book_copy_id) throws ActiveBookRentingServiceImpl.MyException;

    /**
     * This option will save into database user, by id, who is renting a book by book id, book-copy by id that
     * is rented and dateOfRenting - day when book was rented
     * @param user_name - user who rents a book
     * @param book_id - book which is rented
     * @return - user, book, book-copy, dayOfRenting
     * @throws NotFoundException - there is no such user or there is no free copies for renting
     */
    ActiveBookRenting save(String user_name, Long book_id) throws NotFoundException;

    /**
     *This option returns a book by it's id
     * @param id - id of book
     * @return - book if exists
     * @throws IllegalArgumentException - there is no book with provided id
     */
    List<ActiveBookRenting> findByBookId(Long id) throws IllegalArgumentException;

    /**
     * This option returns a user by it's id
     * @param user_id - id of user
     * @return - user
     */
    ActiveBookRenting findByUserId(Long user_id);

    /**
     * Finds all overdue books
     * @param maxDaysForRenting - time period user can hold book
     * @return all books that was returned after the time period defined to keep a book
     */
    List<ActiveBookRenting> findAllOverdueBooks(int maxDaysForRenting);


}
