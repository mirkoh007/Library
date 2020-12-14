package com.mirko.library.dto;

import com.mirko.library.model.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookToBookDTO implements Converter<Book, BookDTO>{

    @Override
    public BookDTO convert(Book book) {
        return new BookDTO.Builder()
                .withID(book.getId())
                .withTitle(book.getTitle())
                .withAuthorName(book.getAuthorName())
                .withPublisher(book.getPublisher())
                .withDateOfPublishing(book.getDateOfPublishing())
                .build();
    }

    public List<BookDTO> convert(List<Book> books) {
        return books.stream().map(book -> convert(book)).collect(Collectors.toList());
    }
}
