package com.mirko.library.controller;

import com.mirko.library.dto.BookDTO;
import com.mirko.library.dto.BookDTOToBook;
import com.mirko.library.dto.BookToBookDTO;
import com.mirko.library.model.Book;
import com.mirko.library.service.BookService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;
    private final BookToBookDTO bookToBookDTO;
    private final BookDTOToBook bookDTOToBook;


    public BookController(BookService bookService, BookToBookDTO bookToBookDTO, BookDTOToBook bookDTOToBook) {
        this.bookService = bookService;
        this.bookToBookDTO = bookToBookDTO;
        this.bookDTOToBook = bookDTOToBook;
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "This function returns all books from database")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        log.info("Method getAllBooks was called");

        return ResponseEntity.ok(bookToBookDTO.convert(bookService.findAll()));
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "This function returns book from database by matching id")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);

        BookDTO convertedBook = bookToBookDTO.convert(book);

        log.info("Founded book by ID is: {}", convertedBook);

        return ResponseEntity.ok(convertedBook);
    }

    @GetMapping(value = "/title/{title}")
    @ApiOperation(value = "This option will return book by it's title")
    public ResponseEntity<BookDTO> findByTitle(@PathVariable String title) throws NotFoundException {
        Book book = bookService.findByTitle(title);

        BookDTO convertedBook = bookToBookDTO.convert(book);

        log.info("Founded book by title: " + title + " is: " +convertedBook);

        return ResponseEntity.ok(convertedBook);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "This function deletes book from database by matching id")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);

        log.info("Deleted book is book with ID: {}",id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PostMapping(value = "/add")
    @ApiOperation(value = "This function adds book into database")
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO newBook) {
        Book convertedNewBook = bookDTOToBook.convert(newBook);

        Book savedBook = bookService.addBook(convertedNewBook);

        BookDTO convertedSavedBook = bookToBookDTO.convert(savedBook);

        log.info("Added book is: {}", convertedSavedBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertedSavedBook);
    }


    @PutMapping(value = "/{id}")
    @ApiOperation(value = "This function will edit book by matching ID")
    public ResponseEntity<BookDTO> editBook(@Valid @RequestBody BookDTO oldBook, @PathVariable Long id) {
        Book editedBook = bookService.editBook(bookDTOToBook.convert(oldBook));

        BookDTO convertedNewBook = bookToBookDTO.convert(editedBook);

        log.info("Edited book is: {}", convertedNewBook);

        return ResponseEntity.ok(convertedNewBook);
    }
}

