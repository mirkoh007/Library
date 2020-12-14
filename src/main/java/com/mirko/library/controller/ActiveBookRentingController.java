package com.mirko.library.controller;

import com.mirko.library.dto.*;
import com.mirko.library.service.ActiveBookRentingService;
import com.mirko.library.service.ActiveBookRentingServiceImpl;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/renting")
public class ActiveBookRentingController {

    private static final Logger log = LoggerFactory.getLogger(ActiveBookRentingController.class);

    private final ActiveBookRentingService activeBookRentingService;
    private final ActiveBookRentingToActiveBookRentingDTO activeBookRentingToActiveBookRentingDTO;
    private final ActiveOverdueRentingDTOToActiveOverdueRenting activeOverdueRentingDTOToActiveOverdueRenting;
    private final int maxDaysForRenting;
    private final UtilClass utilClass;

    public ActiveBookRentingController(ActiveBookRentingService activeBookRentingService,
                                       ActiveBookRentingToActiveBookRentingDTO activeBookRentingToActiveBookRentingDTO,
                                       ActiveOverdueRentingDTOToActiveOverdueRenting activeOverdueRentingDTOToActiveOverdueRenting,
                                       @Value("${maxDaysForRenting}") int maxDaysForRenting,
                                        UtilClass utilClass) {
        this.activeBookRentingService = activeBookRentingService;
        this.activeBookRentingToActiveBookRentingDTO = activeBookRentingToActiveBookRentingDTO;
        this.activeOverdueRentingDTOToActiveOverdueRenting = activeOverdueRentingDTOToActiveOverdueRenting;
        this.maxDaysForRenting = maxDaysForRenting;
        this.utilClass = utilClass;
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "This function returns all rented books from database")
    public ResponseEntity<List<ActiveBookRentingDTO>> getAllRentedBooks() {
        return ResponseEntity.ok(activeBookRentingToActiveBookRentingDTO.convert(activeBookRentingService.findAll()));
    }

    @GetMapping(value = "/book/{bookID}")
    @ApiOperation(value = "This option will return all rented copies for specific book by providing bookID")
    public ResponseEntity<List<ActiveBookRentingDTO>> getAllRentedBooksByBookID(@PathVariable Long bookID) throws IllegalArgumentException {
        return ResponseEntity.ok(activeBookRentingToActiveBookRentingDTO.convert(activeBookRentingService.findByBookId(bookID)));
    }

    @GetMapping(value = "/user/{user_id}")
    public ResponseEntity<ActiveBookRentingDTO> findByUserID(@PathVariable Long user_id) {

        return ResponseEntity.ok(activeBookRentingToActiveBookRentingDTO.convert(activeBookRentingService.findByUserId(user_id)));
    }

    @GetMapping(value = "/overdue")
    @ApiOperation(value = "This option will return all overdue books")
    public ResponseEntity<List<ActiveOverdueRentingDTO>> findAllOverdueBooks(){

        log.info("Find all overdue books method has been called");
        return ResponseEntity.ok(activeOverdueRentingDTOToActiveOverdueRenting.convert(activeBookRentingService.findAllOverdueBooks(maxDaysForRenting)));
    }

    @PostMapping(value = "/user/{user_name}/book/{book_id}")
    @ApiOperation(value = "This option will add user and his/hers rented book")
    public ResponseEntity<ActiveBookRentingDTO> saveRentedBook(@PathVariable String user_name, @PathVariable Long book_id) throws NotFoundException {
        boolean doesUserNameExists = utilClass.doesUserExists(user_name.toLowerCase());
        if(!doesUserNameExists){
            log.info("ERROR!!! Username does not exist");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        ActiveBookRentingDTO rentedBook = activeBookRentingToActiveBookRentingDTO
                                    .convert(activeBookRentingService.save(user_name, book_id));
        log.info("Rented book is: {}", rentedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentedBook);
    }


    @DeleteMapping(value = "/user/{user_id}/bookcopy/{book_copy_id}")
    @ApiOperation(value = "This option will delete record from rented books because book has been returned")
    public ResponseEntity<Void> returnedBook(@PathVariable Long user_id, @PathVariable Long book_copy_id) throws ActiveBookRentingServiceImpl.MyException {
        activeBookRentingService.deleteActiveBookRentingByUserIdAndBookCopyId(user_id,book_copy_id);

        log.info("User with id: " + user_id + " has returned book-copy with id: " + book_copy_id );

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
