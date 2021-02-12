package com.mirko.library.service;

import com.mirko.library.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static com.mirko.library.prototype.UsersPrototype.testListOfUsers;
import static com.mirko.library.prototype.UsersPrototype.testUser;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    private UserRepository userRepository;

    @Before
    public void setup(){
        userRepository = mock(UserRepository.class);
    }

    @Test
    public void findAllUsers() {
        when(userRepository.findAll()).thenReturn(testListOfUsers());

        assertNotNull(testListOfUsers());
        assertEquals(3,testListOfUsers().size());
    }

    @Test
    public void findByID() {
        when(userRepository.findById(1000L)).thenReturn(java.util.Optional.of(testUser()));

        assertNotNull(testUser());
        assertEquals(java.util.Optional.of(1000L),java.util.Optional.of(testUser().getId()));
    }

    @Test
    public void findByUserName() {
        when(userRepository.findByUserName("marthin")).thenReturn(testUser());

        assertNotNull(testUser());
        assertEquals("marthin",testUser().getUserName());
    }
}