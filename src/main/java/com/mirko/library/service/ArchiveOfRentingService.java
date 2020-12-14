package com.mirko.library.service;

import com.mirko.library.model.ArchiveOfRenting;

import java.util.List;

public interface ArchiveOfRentingService {

    /**
     * This option will return all archive from database
     *
     * @return bookId, bookCopyId, userId, dateOfRenting, dateOfReturning
     */
    List<ArchiveOfRenting> findAll();

    /**
     * This option will return all renting for specific user
     *
     * @param id - id that belongs to specific user
     * @return userId
     */

    List<ArchiveOfRenting> findByUserId(Long id);

    /**
     * This option will return specific book by Id
     *
     * @param id - is id of book
     * @return book with that id
     */

    List<ArchiveOfRenting> findByBookId(Long id);

    /**
     * This option will return book-copy by Id
     * @param id - is id of book-copy
     * @return book-copy with that id
     */

    List<ArchiveOfRenting> findByBookCopyId(Long id);

    /**
     * This option will save into database userid, bookid, bookcopyid and dateOfRenting
     * @param archive - containg userid, bookid, bookcopyid, dateOfRenting and dateOfReturning
     */
    void save(ArchiveOfRenting archive);

    /**
     * This option will return overdue rented books depends on provided criteria: maxDaysForRenting
     * and howMany books user wants to see in result
     * @param maxDaysForRenting - defined renting period in days
     * @param howMany - how many books should be obtained from database (eg - give me 3 overdue books)
     * @return - returns specific number of overdue books defined with howMany, matching with
     * defined maximum days for renting -> maxDaysForRenting
     */

    List<ArchiveOfRenting> findSpecificNumberOverdueBooks(int maxDaysForRenting, Long howMany);

    /**
     * This option will return all overdue books that are stored in database
     * @param maxDaysForRenting - defined renting period in days
     * @return - all books that was not returned in certain time period
     */
    List<ArchiveOfRenting> findAllOverdueBooks(int maxDaysForRenting);
}
