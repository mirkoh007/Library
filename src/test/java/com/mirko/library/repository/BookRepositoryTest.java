package com.mirko.library.repository;

import com.mirko.library.model.Book;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.mirko.library.prototype.BookPrototype.testBook;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findByTitle() {
        bookRepository.save(testBook());
        Book foundBook = bookRepository.findByTitle(testBook().getTitle());
        Assert.assertNotNull(foundBook);
        Assert.assertEquals(foundBook.getTitle(),testBook().getTitle());

    }
}