package com.pugal.Blog.service;

import com.pugal.Blog.entity.Post;
import com.pugal.Blog.entity.User;
import com.pugal.Blog.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public void createPost(Post post) {
        postRepo.save(post);
    }

}
