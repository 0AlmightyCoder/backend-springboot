package com.spring.data_jpa.service;

import com.spring.data_jpa.payload.postdto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    // create postDto
    CreatePostDto createPost(CreatePostDto createPostDto, Integer userId, Integer categoryId);

    // get post by id
    ShowPostDto getPostById(Integer id);

    // get all posts
    List<ShowPostDto> getAllPosts();

    // get all post by category
    List<PostCategoryDto> getAllPostByCategory(Integer categoryId);

    // get all post By User
    List<ShowPostDto> getAllPostByUser(Integer userId);

    // search post
    List<ShowPostDto> searchPost(String keyword);

    // update post
    UpdatePostDto updatePost(UpdatePostDto updatePostDto, Integer id);

    // delete post
    void deletePost(Integer id);
}
