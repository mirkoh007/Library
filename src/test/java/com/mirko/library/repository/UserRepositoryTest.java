package com.mirko.library.repository;

import com.mirko.library.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.mirko.library.prototype.UsersPrototype.testUser;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
   public void findByUserName() {

        userRepository.save(testUser());
        User foundUser = userRepository.findByUserName(testUser().getUserName());
        Assert.assertNotNull(foundUser);
        Assert.assertEquals(foundUser.getUserName(),testUser().getUserName());

    }
}