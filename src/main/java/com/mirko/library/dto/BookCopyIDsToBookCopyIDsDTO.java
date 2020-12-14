package com.mirko.library.dto;

import com.mirko.library.model.BookCopy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyIDsToBookCopyIDsDTO implements Converter<BookCopy, BookCopyIDsDTO> {
    @Override
    public BookCopyIDsDTO convert(BookCopy bookCopy) {

        return new BookCopyIDsDTO.Builder()
                .withBookCopyID(bookCopy.getId())
                .withBookID(bookCopy.getBook().getId())
                .build();
    }

    public List<BookCopyIDsDTO> convert(List<BookCopy> bookCopies){
        return bookCopies.stream().map(bookCopy -> convert(bookCopy)).collect(Collectors.toList());
    }
}
