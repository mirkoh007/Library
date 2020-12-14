package com.mirko.library.service;

import com.mirko.library.model.ActiveBookRenting;
import com.mirko.library.model.User;
import com.mirko.library.repository.ActiveBookRentingRepository;
import com.mirko.library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ActiveBookRentingRepository activeBookRentingRepository;

    public UserServiceImpl(UserRepository userRepository, ActiveBookRentingRepository activeBookRentingRepository) {
        this.userRepository = userRepository;
        this.activeBookRentingRepository = activeBookRentingRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByID(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        ActiveBookRenting user = activeBookRentingRepository.findByUserId(id);
        if(user != null) {
            throw new IllegalArgumentException("User is renting a book. Can't delete user with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


}
