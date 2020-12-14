package com.mirko.library.controller;

import com.mirko.library.dto.UserDTO;
import com.mirko.library.model.User;
import com.mirko.library.service.UserService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class UtilClass {

    private static final Logger log = LoggerFactory.getLogger(UtilClass.class);

    private final UserService userService;

    UtilClass(UserService userService) {
        this.userService = userService;
    }

     boolean doesUserExists(UserDTO userDTO){
        log.info("Doesusetexists method call");

        String newUserName = userDTO.getUserName();
        log.info("Name of username that we are looking for: {}", newUserName);

        User oldUser =findItByUserName(newUserName);
        if(oldUser == null) {log.info("doesnot exists");}
        else{log.info("does exists");}

        return oldUser != null;
    }

    boolean doesUserExists(String userName){
        User oldUser =findItByUserName(userName);
        if(oldUser == null) {log.info("doesnot exists"); return false;}
        else{log.info("does exists"); return true;}


    }

    User findItByUserName(String userName){
        log.info("finditbyusername method call");
        return userService.findByUserName(userName);
    }


    boolean doesUserExists(Long user_id) throws NotFoundException {
        User user = userService.findByID(user_id);
        if(user.getId() != 0){
            return true;
        }else {
            throw new NotFoundException("No such user");
        }
    }

}
