package com.mirko.library.repository;

import com.mirko.library.model.ActiveBookRentID;
import com.mirko.library.model.ActiveBookRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActiveBookRentingRepository extends JpaRepository<ActiveBookRenting, ActiveBookRentID> {

    void deleteActiveBookRentingByUserIdAndBookCopyId(Long user_id, Long book_copy_id);

    List<ActiveBookRenting> findByBookId(Long id);
    ActiveBookRenting findByBookCopyId(Long id);

    ActiveBookRenting findByUserId(Long id);

    @Query(value = "SELECT book_id, book_copy_id, user_id, date_of_renting" +
            " From rentedbooks where datediff(day,date_of_renting,current_date())> :maxDaysForRenting " +
            "order by datediff(day,date_of_renting,current_date()) desc ", nativeQuery = true)
    List<ActiveBookRenting> findAllOverdueBooks(int maxDaysForRenting);
}
