package com.mirko.library.dto;

import com.mirko.library.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User user) {
        return new UserDTO.Builder()
                .withID(user.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withUserName(user.getUserName())
                .withPassword(user.getPassword())
                .withEmail(user.getEmail())
                .withRole(user.getRole())
                .build();
    }

    public List<UserDTO> convert(List<User> users){
        return users.stream().map(this::convert).collect(Collectors.toList());
    }
}
