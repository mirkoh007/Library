package com.mirko.library.dto;

import com.mirko.library.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToUserDTOOut implements Converter<User, UserDTOOut> {

    @Override
    public UserDTOOut convert(User user) {
        return new UserDTOOut.Builder()
                .withID(user.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withUserName(user.getUserName())
                .withEmail(user.getEmail())
                .build();
    }

    public List<UserDTOOut> convert(List<User> users){
        return users.stream().map(user -> convert(user)).collect(Collectors.toList());
    }
}
