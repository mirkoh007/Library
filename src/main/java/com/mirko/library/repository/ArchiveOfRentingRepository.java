package com.mirko.library.repository;

import com.mirko.library.model.ArchiveOfRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArchiveOfRentingRepository extends JpaRepository<ArchiveOfRenting, Long> {

    List<ArchiveOfRenting> findAll();

    List<ArchiveOfRenting> findByUserId(Long id);

    List<ArchiveOfRenting> findByBookId(Long id);

    List<ArchiveOfRenting> findByBookCopyId(Long id);

    @Query(value = "SELECT id, book_id, book_copy_id, user_id, date_of_renting, date_of_returning" +
                   " From archives where datediff(day,date_of_renting,date_of_returning)> :maxDaysForRenting " +
                   "order by datediff(day,date_of_renting,date_of_returning) desc limit :howMany", nativeQuery = true)
    List<ArchiveOfRenting> findSpecificNumberOverdueBooks(int maxDaysForRenting, Long howMany);

    @Query(value = "SELECT id, book_id, book_copy_id, user_id, date_of_renting, date_of_returning" +
            " From archives where datediff(day,date_of_renting,date_of_returning)> :maxDaysForRenting " +
            "order by datediff(day,date_of_renting,date_of_returning) desc ", nativeQuery = true)
    List<ArchiveOfRenting> findAllOverdueBooks(int maxDaysForRenting);

}
