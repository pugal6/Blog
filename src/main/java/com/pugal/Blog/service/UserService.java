package com.pugal.Blog.service;

import com.pugal.Blog.entity.User;
import com.pugal.Blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public void createUsers(User user) {
        userRepo.save(user);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(UUID id) {
        return userRepo.findById(id).get();
    }
}
