package com.pugal.Blog.service;

import com.pugal.Blog.entity.User;
import com.pugal.Blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public void createUsers(User user) {
        userRepo.save(user);
    }
}
