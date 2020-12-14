package com.mirko.library.controller;

import com.mirko.library.dto.BookCopyDTO;
import com.mirko.library.dto.BookCopyToBookCopyDTO;
import com.mirko.library.dto.RentedBookCopiesIDsDTO;
import com.mirko.library.dto.RentedBookCopiesIDsToRentedBookCopiesIDsDTO;
import com.mirko.library.model.BookCopy;
import com.mirko.library.repository.ActiveBookRentingRepository;
import com.mirko.library.service.BookCopyService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookcopy")
public class BookCopyController {

    private static final Logger log = LoggerFactory.getLogger(BookCopyController.class);

    private final BookCopyService bookCopyService;
    private final BookCopyToBookCopyDTO bookCopyToBookCopyDTO;
    private final RentedBookCopiesIDsToRentedBookCopiesIDsDTO rentedBookCopiesIDsToRentedBookCopiesIDsDTO;
    private final ActiveBookRentingRepository activeBookRentingRepository;

    public BookCopyController(BookCopyService bookCopyService,
                              BookCopyToBookCopyDTO bookCopyToBookCopyDTO, RentedBookCopiesIDsToRentedBookCopiesIDsDTO rentedBookCopiesIDsToRentedBookCopiesIDsDTO, ActiveBookRentingRepository activeBookRentingRepository) {
        this.bookCopyService = bookCopyService;
        this.bookCopyToBookCopyDTO = bookCopyToBookCopyDTO;

        this.rentedBookCopiesIDsToRentedBookCopiesIDsDTO = rentedBookCopiesIDsToRentedBookCopiesIDsDTO;
        this.activeBookRentingRepository = activeBookRentingRepository;
    }

    @GetMapping
    @ApiOperation(value = "This function returns all book copies from database")
    public ResponseEntity<List<BookCopyDTO>> getAllCopies() {
        log.info("Method getAllCopies was called");
        return ResponseEntity.ok(bookCopyToBookCopyDTO.convert(bookCopyService.finAll()));
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "This function return book copy by provided id")
    public ResponseEntity<BookCopyDTO> findById(@PathVariable Long id) {
        BookCopy bookCopy = bookCopyService.findById(id);

        BookCopyDTO convertedBookCopy = bookCopyToBookCopyDTO.convert(bookCopy);

        log.info("Founded book by ID is: {}", convertedBookCopy);

        return ResponseEntity.ok(convertedBookCopy);
    }

    @GetMapping(value = "/bookcopies/{book_id}")
    @ApiOperation(value = "This option will show all rented book-copies that bolongs to a certain book")
    public ResponseEntity<List<RentedBookCopiesIDsDTO>> getAllRentedBookCopiesIds(@PathVariable Long book_id) {

        return ResponseEntity.ok(rentedBookCopiesIDsToRentedBookCopiesIDsDTO.convert(activeBookRentingRepository.findByBookId(book_id)));


    }

    @PostMapping
    @ApiOperation(value = "This option will add a book copy into database, for specific book by providing a book id")
    public ResponseEntity<BookCopyDTO> saveBookCopy(Long id) {
        BookCopyDTO savedBook = bookCopyToBookCopyDTO.convert(bookCopyService.saveBookCopy(id));

         log.info("Added book copy is: {}", savedBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "This option will delete a book copy from database")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws IllegalArgumentException {
        bookCopyService.delete(id);

        log.info("Deleted bookcopy is bookcopy with ID: {}", id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
