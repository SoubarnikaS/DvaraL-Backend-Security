package com.sdp.dvaralbackendsecurity.service;


import com.sdp.dvaralbackendsecurity.model.User;
import com.sdp.dvaralbackendsecurity.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User addUser(User user) {

        return userRepository.save(user);

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUser(Long userID) {
        return userRepository.findById(userID).get();
    }
}
