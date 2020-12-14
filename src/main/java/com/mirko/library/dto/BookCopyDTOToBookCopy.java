package com.mirko.library.dto;

import com.mirko.library.model.BookCopy;
import com.mirko.library.service.BookService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyDTOToBookCopy implements Converter<BookCopyDTO, BookCopy>{

    private final BookService bookService;

    public BookCopyDTOToBookCopy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public BookCopy convert(BookCopyDTO bookCopyDTO) {
        return new BookCopy.Builder()
                .withSerial(bookCopyDTO.getSerialNumber())
                .withBook(bookService.findById(bookCopyDTO.getId()))
                .build();
    }

    public List<BookCopy> convert(List<BookCopyDTO> bookCopyDTOS) {

        return bookCopyDTOS.stream().map(bookCopyDTO -> convert(bookCopyDTO)).collect(Collectors.toList());
    }

}
