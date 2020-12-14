package com.mirko.library.repository;

import com.mirko.library.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCopyRepository extends JpaRepository <BookCopy, Long> {

    List<BookCopy> findByBook_Id(Long id);

}
