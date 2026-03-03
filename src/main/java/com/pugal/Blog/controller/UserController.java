package com.pugal.Blog.controller;

import com.pugal.Blog.entity.User;
import com.pugal.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<User> createUsers(@RequestBody User user) {
        userService.createUsers(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
