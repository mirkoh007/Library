package com.mirko.library.controller;

import com.mirko.library.dto.*;
import com.mirko.library.model.User;
import com.mirko.library.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserToUserDTOOut userToUserDTOOut;
    private final UserDTOToUser userDTOToUser;
    private final UserToUserDTO userToUserDTO;
    private final UserService userService;
    private final UtilClass utilClass;


    public UserController(UserToUserDTOOut userToUserDTOOut,
                          UserDTOToUser userDTOToUser,
                          UserToUserDTO userToUserDTO,
                          UserService userService,
                          UtilClass utilClass) {
        this.userToUserDTOOut = userToUserDTOOut;
        this.userDTOToUser = userDTOToUser;
        this.userToUserDTO = userToUserDTO;
        this.userService = userService;
        this.utilClass = utilClass;
    }


    @GetMapping
    @ApiOperation(value = "This option will return all users from database")
    public ResponseEntity<List<UserDTOOut>> getAllUsers() {
        log.info("Method getAllUsers() was called");
        return ResponseEntity.ok(userToUserDTOOut.convert(userService.findAllUsers()));
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "This option will return user by matching id")
    public ResponseEntity<UserDTOOut> findUserByID(@PathVariable Long id){
        User user = userService.findByID(id);

        UserDTOOut convertedUser = userToUserDTOOut.convert(user);

        log.info("Founded user is: {}", convertedUser);

        return ResponseEntity.ok(convertedUser);

    }

    @GetMapping(value = "/username/{userName}")
    @ApiOperation(value = "This will return user by given username")
    public ResponseEntity<UserDTOOut> findUserByUserName(@PathVariable String userName){
        User foundedUser = utilClass.findItByUserName(userName);
        if(foundedUser == null){
            log.info("User with given username: " + "{}," + " was not found ", userName);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        UserDTOOut convertedFoundedUser = userToUserDTOOut.convert(foundedUser);

        log.info("Founded user with username: {}", convertedFoundedUser);

        return ResponseEntity.ok(convertedFoundedUser);

    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "This option will delete user from database")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);

        log.info("Deleted user is user with ID: {}", id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    @ApiOperation(value = "This option will save user")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO newUser){
        boolean doesUserNameExists = utilClass.doesUserExists(newUser);
        if(doesUserNameExists){
            log.info("Username already taken");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        User convertUser = userDTOToUser.convert(newUser);

        User savedUser = userService.saveUser(convertUser);

        UserDTO convertedDTOUser = userToUserDTO.convert(savedUser);

        log.info("Added user is: {}", convertedDTOUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertedDTOUser);

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "This option edits user details")
    public ResponseEntity<UserDTOOut> editUser(@Valid @RequestBody UserDTO userDTO, @PathVariable @NotBlank Long id){
        if(!id.equals(userDTO.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        User editedUser = userService.saveUser(userDTOToUser.convert(userDTO));

        UserDTOOut convertedUser = userToUserDTOOut.convert(editedUser);

        log.info("Edited user is: {}", convertedUser);

        return ResponseEntity.ok(convertedUser);
    }

}
