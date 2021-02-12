package com.mirko.library.service;

import com.mirko.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import static com.mirko.library.prototype.BookPrototype.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceImplTest {
    private  BookRepository bookRepository;

    @Before
    public void setup(){
        bookRepository = mock(BookRepository.class);

    }

    @Test
    public void findAll() {

        when(bookRepository.findAll()).thenReturn(testListOfBooks());

        assertNotNull(testListOfBooks());
        assertEquals(3,testListOfBooks().size());
    }

    @Test
    public void findById() {
        //testBook2() is declared in BookPrototype class in prototype package
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(testBook2()));

        assertNotNull(testBook2());
       assertEquals(java.util.Optional.of(1L),java.util.Optional.of(testBook2().getId()));

    }

    @Test
    public void findByTitle(){
        when(bookRepository.findByTitle("Pjevajmo do Zore")).thenReturn(testBook());

        assertNotNull(testBook());
        assertEquals("Pjevajmo do Zore", testBook().getTitle());
    }
}