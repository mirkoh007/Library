package com.mirko.library.controller;


import com.mirko.library.dto.ArchiveOfRentingDTO;
import com.mirko.library.dto.ArchiveOfRentingToArchiveOfRentingDTO;
import com.mirko.library.dto.ArchiveOverdueBookDTO;
import com.mirko.library.dto.ArchiveOverdueBookToOverdueBookDTO;
import com.mirko.library.model.ArchiveOfRenting;
import com.mirko.library.repository.ArchiveOfRentingRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statistic")
public class ArchiveOfRentingController {

    private static final Logger log = LoggerFactory.getLogger(ArchiveOfRentingController.class);

    private final ArchiveOfRentingToArchiveOfRentingDTO archiveOfRentingToArchiveOfRentingDTO;
    private final ArchiveOfRentingRepository archiveOfRentingRepository;
    private final ArchiveOverdueBookToOverdueBookDTO archiveOverdueBookToOverdueBookDTO;
    private final int maxDaysForRenting;

    public ArchiveOfRentingController(ArchiveOfRentingToArchiveOfRentingDTO archiveOfRentingToArchiveOfRentingDTO,
                                      ArchiveOfRentingRepository archiveOfRentingRepository,
                                      ArchiveOverdueBookToOverdueBookDTO archiveOverdueBookToOverdueBookDTO,
                                      @Value("${maxDaysForRenting}") int maxDaysForRenting) {
        this.archiveOfRentingToArchiveOfRentingDTO = archiveOfRentingToArchiveOfRentingDTO;
        this.archiveOfRentingRepository = archiveOfRentingRepository;
        this.archiveOverdueBookToOverdueBookDTO = archiveOverdueBookToOverdueBookDTO;
        this.maxDaysForRenting = maxDaysForRenting;
    }


    @GetMapping
    @ApiOperation(value = "This option will show all archive")
    public ResponseEntity<List<ArchiveOfRentingDTO>> getAllArchive(){

        log.info("Method get all archive has been called");
        return ResponseEntity.ok(archiveOfRentingToArchiveOfRentingDTO.converter(archiveOfRentingRepository.findAll()));
    }

    @GetMapping(value = "/user/{user_id}")
    @ApiOperation(value = "This option will return all rentings for specific user by his/hers id")
    public ResponseEntity<List<ArchiveOfRentingDTO>> getAllForSpecificUser(@PathVariable Long user_id){
        log.info("Method get user statistic has been called");
        List<ArchiveOfRenting> userById = archiveOfRentingRepository.findByUserId(user_id);
        if(userById.size() == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(archiveOfRentingToArchiveOfRentingDTO.converter(userById));
    }

    @GetMapping(value = "/overdue")
    @ApiOperation(value = "This option will provide at return all overdue books")
    public ResponseEntity<List<ArchiveOverdueBookDTO>> getAllOverdueBooks(){
        log.info("Method get all overdue books was called");
        return ResponseEntity.ok(archiveOverdueBookToOverdueBookDTO.convert(archiveOfRentingRepository.findAllOverdueBooks(maxDaysForRenting)));
    }

    @GetMapping(value = "overdue/{howManyBooks}")
    @ApiOperation(value = "This option will provide specific number of overdue books")
    public ResponseEntity<List<ArchiveOverdueBookDTO>> getNumberOfOverdueBooks(@PathVariable Long howManyBooks){
        List<ArchiveOverdueBookDTO> archiveOverdueBookDTOS = archiveOverdueBookToOverdueBookDTO.convert(archiveOfRentingRepository.findSpecificNumberOverdueBooks(maxDaysForRenting, howManyBooks));
        log.info("Overdue books are: {}", archiveOverdueBookDTOS);

        return ResponseEntity.ok(archiveOverdueBookDTOS);
    }

}
