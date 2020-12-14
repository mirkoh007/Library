package com.mirko.library.dto;

import com.mirko.library.model.BookCopy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyToBookCopyDTO implements Converter<BookCopy, BookCopyDTO> {

    private final BookToBookDTO bookToBookDTO;

    public BookCopyToBookCopyDTO(BookToBookDTO bookToBookDTO){
        this.bookToBookDTO = bookToBookDTO;
    }

    @Override
    public BookCopyDTO convert(BookCopy bookCopy) {

        BookDTO bookDTO = bookToBookDTO.convert(bookCopy.getBook());

        return new BookCopyDTO.Builder()
                .withId(bookCopy.getId())
                .withSerialNumber(bookCopy.getSerialNumber())
                .withBookDTO(bookDTO)
                .build();

    }

    public List<BookCopyDTO> convert(List<BookCopy> bookCopies) {
        return bookCopies.stream().map(bookCopy -> convert(bookCopy)).collect(Collectors.toList());
    }

}

