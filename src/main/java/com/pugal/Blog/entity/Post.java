package com.pugal.Blog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.Text;

import java.util.UUID;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String post;

}
