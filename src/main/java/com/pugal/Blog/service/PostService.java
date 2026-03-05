package com.pugal.Blog.service;

import com.pugal.Blog.entity.Post;
import com.pugal.Blog.entity.User;
import com.pugal.Blog.repo.PostRepo;
import com.pugal.Blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    public Post createPost(Post post) {
        User user = userRepo.findById(post.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        post.setUser(user);
        postRepo.save(post);
        return post;
    }

    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    public Post updatePost(UUID id, Post post) {
        Post p = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        p.setPost(post.getPost());
        p.setTitle(post.getTitle());
        p.setUser(post.getUser());
        postRepo.save(p);
        return p;
    }

    public String deletePost(UUID id) {
         Post p = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post doesn't exist"));
         postRepo.deleteById(p.getPostId());
         return "Post deleted";
    }

    public List<Post> getPostsOfUser(UUID id) {
        return postRepo.findByUserId(id);
    }
}
