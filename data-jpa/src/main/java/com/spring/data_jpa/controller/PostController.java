package com.spring.data_jpa.controller;

import com.spring.data_jpa.payload.postdto.CreatePostDto;

import com.spring.data_jpa.payload.postdto.ShowPostDto;
import com.spring.data_jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    // add post to database
    @PostMapping("/user/{userId}/category/{categoryId}/create-posts")
    public ResponseEntity<CreatePostDto> makePost(@RequestBody CreatePostDto createPostDto, @PathVariable("userId")Integer userId, @PathVariable("categoryId")Integer categoryId) {
        CreatePostDto savedPost = postService.createPost(createPostDto, userId, categoryId);
        return new ResponseEntity<>(createPostDto, HttpStatus.CREATED);
    }

    // get post from database
    @GetMapping("/post/{postId}")
    public ResponseEntity<ShowPostDto> fetchById(@PathVariable("postId")Integer postId) {
        System.out.println("request reached to post controller's fetchById method...");
        ShowPostDto showPost = this.postService.getPostById(postId);
        System.out.println("post controller loaded");
        return ResponseEntity.ok(showPost);
    }

    // get all posts from database
    public ResponseEntity<List<ShowPostDto>> fetchAllPosts() {
        List<ShowPostDto> postsList = this.postService.getAllPosts();
        return ResponseEntity.ok(postsList);
    }
}
