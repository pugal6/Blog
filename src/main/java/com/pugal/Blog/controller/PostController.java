package com.pugal.Blog.controller;

import com.pugal.Blog.entity.Post;
import com.pugal.Blog.entity.User;
import com.pugal.Blog.service.PostService;
import com.pugal.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        User user = userService.getUserById(post.getUser().getId());
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        post.setUser(user);
        postService.createPost(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
