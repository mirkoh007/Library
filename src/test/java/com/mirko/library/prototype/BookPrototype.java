package com.mirko.library.prototype;

import com.mirko.library.dto.BookDTO;
import com.mirko.library.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookPrototype {

    public static Book testBook(){
        return new Book.Builder()
                .withAuthorName("Pjotr Iljic Cajkovski")
                .withDateOfPublishig(LocalDate.now())
                .withPublisher("Ruskaja Knjigaja")
                .withTitle("Pjevajmo do Zore")
                .build();
        
    }

    public static Book testBook2(){
        Book testBook2 = new Book();
        testBook2.setId(1L);
        testBook2.setTitle("Moja ziva muka");
        testBook2.setAuthorName("Nikola Bulatovic");
        testBook2.setPublisher("Laguna");
        testBook2.setDateOfPublishing(LocalDate.now());
        return testBook2;
    }

    public static List<Book> testListOfBooks(){
        List<Book> testListOfBooks = new ArrayList<>();
        testListOfBooks.add(new Book.Builder()
                .withAuthorName("Pjotr Iljic Cajkovski")
                .withDateOfPublishig(LocalDate.now())
                .withPublisher("Ruskaja Knjigaja")
                .withTitle("Pjevajmo do Zore")
                .build());

        testListOfBooks.add(new Book.Builder()
                .withAuthorName("Gaj Julije Cezar")
                .withDateOfPublishig(LocalDate.now())
                .withPublisher("Pustinja")
                .withTitle("Kocka je bacena")
                .build());

        testListOfBooks.add(new Book.Builder()
                .withAuthorName("Maksim Gorki")
                .withDateOfPublishig(LocalDate.now())
                .withPublisher("Ruskaja Knjigaja")
                .withTitle("Pasulj")
                .build());

        return testListOfBooks;
    }

    public static BookDTO testBookDTO(){
        return new BookDTO.Builder()
                .withID(1L)
                .withTitle("Milos Crnjanski")
                .withAuthorName("Milos Crnjanski")
                .withPublisher("Laguna")
                .withDateOfPublishing(LocalDate.now())
                .build();
    }

    public static List<BookDTO> testListOfBooksDTO(){
        List<BookDTO> testListOfBooksDTO = new ArrayList<>();
        testListOfBooksDTO.add(new BookDTO.Builder()
                .withID(1L)
                .withAuthorName("Pjotr Iljic Cajkovski")
                .withDateOfPublishing(LocalDate.now())
                .withPublisher("Ruskaja Knjigaja")
                .withTitle("Pjevajmo do Zore")
                .build());

        testListOfBooksDTO.add(new BookDTO.Builder()
                .withID(2L)
                .withAuthorName("Gaj Julije Cezar")
                .withDateOfPublishing(LocalDate.now())
                .withPublisher("Pustinja")
                .withTitle("Kocka je bacena")
                .build());

        testListOfBooksDTO.add(new BookDTO.Builder()
                .withID(3L)
                .withAuthorName("Maksim Gorki")
                .withDateOfPublishing(LocalDate.now())
                .withPublisher("Ruskaja Knjigaja")
                .withTitle("Pasulj")
                .build());

        return testListOfBooksDTO;
    }

}
