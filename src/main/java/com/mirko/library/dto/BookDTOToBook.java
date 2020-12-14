package com.mirko.library.dto;

import com.mirko.library.model.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDTOToBook implements Converter<BookDTO, Book>{

    @Override
    public Book convert(BookDTO bookDTO) {
        return new Book.Builder()
                .withID(bookDTO.getId())
                .withTitle(bookDTO.getTitle())
                .withAuthorName(bookDTO.getAuthorName())
                .withPublisher(bookDTO.getPublisher())
                .withDateOfPublishig(bookDTO.getDateOfPublishing())
                .build();
    }

    public List<Book> convert(List<BookDTO> bookDTOS) {
        return bookDTOS.stream().map(bookDTO -> convert(bookDTO)).collect(Collectors.toList());
    }
}
