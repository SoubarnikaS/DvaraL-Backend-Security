package com.sdp.dvaralbackendsecurity.controller;


import com.sdp.dvaralbackendsecurity.model.User;
import com.sdp.dvaralbackendsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/fetch/allUser")
    public ResponseEntity<?> getAllUsers() {

        try{
            List<User> usersList = userService.getAllUsers();

            if (!usersList.isEmpty()) {
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
