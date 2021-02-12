package com.mirko.library.prototype;

import com.mirko.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersPrototype {

    public static User testUser(){

        return new User.Builder()
                .withId(1000L)
                .withEmail("mirkoh@gmail.com")
                .withFirstName("Martin")
                .withLastName("Misterija")
                .withPassword("pozdrav")
                .withUserName("marthin")
                .build();
    }

    public static List<User> testListOfUsers(){
        List<User> testListOfUsers = new ArrayList<>();
        testListOfUsers.add(new User.Builder()
            .withId(1L)
            .withEmail("milojkopantic@gmail.com")
            .withFirstName("Milojko")
            .withLastName("Pantic")
            .withPassword("pantic11")
            .withUserName("milojkopantic")
            .build());

        testListOfUsers.add(new User.Builder()
                .withId(2L)
                .withEmail("bojanko@hotmail.com")
                .withFirstName("Bojan")
                .withLastName("Kovacevic")
                .withPassword("aprilili")
                .withUserName("kovaboja")
                .build());

        testListOfUsers.add(new User.Builder()
                .withId(3L)
                .withEmail("milos@yahoo.com")
                .withFirstName("Milos")
                .withLastName("Obilic")
                .withPassword("muratgone")
                .withUserName("obilic")
                .build());

        return testListOfUsers;
    }


}
