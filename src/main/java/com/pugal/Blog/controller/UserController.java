package com.pugal.Blog.controller;

import com.pugal.Blog.entity.User;
import com.pugal.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUsers(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers() {
       List<User> users =  userService.getUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID id) {
        String deleted = userService.deleteUser(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
