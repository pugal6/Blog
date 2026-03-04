package com.pugal.Blog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.Text;

import java.util.UUID;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;
    @ManyToOne
    private User user;
    private String title;
    private String post;

}
