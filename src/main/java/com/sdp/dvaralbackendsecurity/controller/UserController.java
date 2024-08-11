package com.sdp.dvaralbackendsecurity.controller;


import com.sdp.dvaralbackendsecurity.dto.StatusDto;
import com.sdp.dvaralbackendsecurity.model.User;
import com.sdp.dvaralbackendsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/auth")
@Slf4j
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

    @GetMapping("/getUserId")
    public ResponseEntity<Long> getUserIdByEmail(@RequestParam String email) {
        Long userId = userService.findUserIdByEmail(email);
        if (userId != null) {
            return ResponseEntity.ok(userId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/manager-account/{userID}")
    public ResponseEntity<?> updateUser(@PathVariable Long userID, @RequestBody StatusDto accountStatus) {
        try{
            Boolean response = userService.updateAccountStatus(userID, accountStatus);

            if(response)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
