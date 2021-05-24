package com.mirko.library.dto;

import com.mirko.library.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

    private final PasswordEncoder passwordEncoder;

    public UserDTOToUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User convert(UserDTO userDTO) {

       return new User.Builder()
               .withId(userDTO.getId())
               .withFirstName(userDTO.getFirstName())
               .withLastName(userDTO.getLastName())
               .withUserName(userDTO.getUserName())
               .withPassword(passwordEncoder.encode(userDTO.getPassword()))
               .withEmail(userDTO.getEmail())
               .withRole(userDTO.getRole())
               .build();
    }

    public List<User> convert(List<UserDTO> userDTOS){
        return userDTOS.stream().map(userDTO -> convert(userDTO)).collect(Collectors.toList());

    }
}
