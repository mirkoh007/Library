package com.mirko.library.controller;

import com.mirko.library.dto.RentedBookCopiesIDsDTO;
import com.mirko.library.dto.RentedBookCopiesIDsToRentedBookCopiesIDsDTO;
import com.mirko.library.repository.ActiveBookRentingRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/findbookcopyids")
public class RentedBookCopyIdsController {

    private final RentedBookCopiesIDsToRentedBookCopiesIDsDTO rentedBookCopiesIDsToRentedBookCopiesIDsDTO;
    private final ActiveBookRentingRepository activeBookRentingRepository;

    public RentedBookCopyIdsController(RentedBookCopiesIDsToRentedBookCopiesIDsDTO rentedBookCopiesIDsToRentedBookCopiesIDsDTO,
                                       ActiveBookRentingRepository activeBookRentingRepository) {
        this.rentedBookCopiesIDsToRentedBookCopiesIDsDTO = rentedBookCopiesIDsToRentedBookCopiesIDsDTO;
        this.activeBookRentingRepository = activeBookRentingRepository;
    }

    @GetMapping(value = "/{book_id}")
    @ApiOperation(value = "This option will show all rented book-copies that bolongs to a certain book")
    public ResponseEntity<List<RentedBookCopiesIDsDTO>> getAllRentedBookCopiesIds(@PathVariable Long book_id) {

        return ResponseEntity.ok(rentedBookCopiesIDsToRentedBookCopiesIDsDTO.convert(activeBookRentingRepository.findByBookId(book_id)));


    }

}
