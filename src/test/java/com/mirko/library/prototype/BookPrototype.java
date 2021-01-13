package com.mirko.library.prototype;

import com.mirko.library.model.Book;

import java.time.LocalDate;

public class BookPrototype {
    public static Book testBook(){
        return new Book.Builder()
                .withAuthorName("Pjotr Iljic Cajkovski")
                .withDateOfPublishig(LocalDate.now())
                .withPublisher("Ruskaja Knjigaja")
                .withTitle("Pjevajmo do Zore")
                .build();
    }
}
