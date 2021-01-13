package com.mirko.library.prototype;

import com.mirko.library.model.User;

public class UsersPrototype {
    public static User testUser(){
//        User user = new User();
//        user.setId(1000L);
//        user.setEmail("mirkoh@gmail.com");
//        user.setFirstName("Mirko");
//        user.setLastName("Hajduk");
//        user.setPassword("pozdrav");
//        user.setUserName("mirko");

        return new User.Builder()
                .withId(1000L)
                .withEmail("mirkoh@gmail.com")
                .withFirstName("Mirko")
                .withLastName("Hajduk")
                .withPassword("pozdrav")
                .withUserName("mirko")
                .build();
    }
}
