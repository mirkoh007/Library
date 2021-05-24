package com.mirko.library.errorhandler;

import com.mirko.library.controller.BookController;
import com.mirko.library.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, "Something Seriously went wrong", e);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e) {
        return error(NOT_FOUND, "There in no such id.", e);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<String> emptyResultDataAccessException(EmptyResultDataAccessException e) {
        return error(NOT_FOUND, "There in no such id.", e);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException e) {
        return error(INTERNAL_SERVER_ERROR, "There in no such id.", e);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return error(INTERNAL_SERVER_ERROR, "There in no such id.", e);
    }

    private ResponseEntity error(HttpStatus status, String message, Exception e) {
        log.error("Exception ", e);
        ErrorDTO errorDTO = new ErrorDTO.Builder()
                .developerMessage(message)
                .statusCode(status.toString())
                .timestamp(LocalDateTime.now())
                .message(message)
                .build();
        return ResponseEntity.status(status).body(errorDTO);
    }

}
