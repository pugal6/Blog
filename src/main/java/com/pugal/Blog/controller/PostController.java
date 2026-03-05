package com.pugal.Blog.controller;

import com.pugal.Blog.entity.Post;
import com.pugal.Blog.entity.User;
import com.pugal.Blog.service.PostService;
import com.pugal.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post p = postService.createPost(post);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("posts")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<List<Post>> getPostsOfUser(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        List<Post> posts = postService.getPostsOfUser(user.getId());
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID id, @RequestBody Post post) {
        Post p = postService.updatePost(id,post);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable UUID id) {
        String deleted = postService.deletePost(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
