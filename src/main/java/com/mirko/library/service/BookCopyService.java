package com.mirko.library.service;

import com.mirko.library.model.BookCopy;

import java.util.List;

public interface BookCopyService {

    /**
     * This option will return all book-copies from database
     *
     * @return return all book-copies stored in database
     */

    List<BookCopy> finAll();

    /**
     * This option will return a book-copy by provided id
     *
     * @param id is provided id to search book
     * @return book by matching id
     */

    BookCopy findById(Long id);

    /**
     * This option will save book-copy into database by provided id
     *
     * @param id is provided id of the book
     * @return saved book-copy
     */

    BookCopy saveBookCopy(Long id);

    /**
     * This option will delete book-copy. ID of book-copy must be provided for deleting
     *
     * @param id is id of the book copy that will be deleted
     * throws IllegaArgumentException if book-copy was not found by provided id
     */
    void delete(Long id) throws IllegalArgumentException;

    /**
     * Option finds book by matchig id
     * @param id - id of the book we want to find
     * @return - founded book
     */
    List<BookCopy> findByBook_Id(Long id);



}
