package com.mirko.library.controller;


import com.mirko.library.dto.BookCopyIDsDTO;
import com.mirko.library.dto.BookCopyIDsToBookCopyIDsDTO;
import com.mirko.library.service.BookCopyService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/findids")
public class AllBookCopyIdsController {

    private static final Logger log = LoggerFactory.getLogger(BookCopyController.class);

    private final BookCopyIDsToBookCopyIDsDTO bookCopyIDsToBookCopyIDsDTO;
    private final BookCopyService bookCopyService;

    public AllBookCopyIdsController(BookCopyIDsToBookCopyIDsDTO bookCopyIDsToBookCopyIDsDTO, BookCopyService bookCopyService) {
        this.bookCopyIDsToBookCopyIDsDTO = bookCopyIDsToBookCopyIDsDTO;
        this.bookCopyService = bookCopyService;
    }

    @GetMapping(value = "/{book_id}")
    @ApiOperation(value = "This option will show all book-copies in database that belong to certain book")
    public ResponseEntity<List<BookCopyIDsDTO>> getIDsByBookID(@PathVariable Long book_id){
        log.info("Method getAllIDs was called");

       return ResponseEntity.ok(bookCopyIDsToBookCopyIDsDTO.convert(bookCopyService.findByBook_Id(book_id)));
    }
}
