package com.spring.data_jpa.service.Impl;

import com.spring.data_jpa.entity.Category;
import com.spring.data_jpa.entity.Post;
import com.spring.data_jpa.entity.User;
import com.spring.data_jpa.exceptions.RecordNotFoundException;
import com.spring.data_jpa.payload.postdto.*;
import com.spring.data_jpa.repositories.CategoryRepo;
import com.spring.data_jpa.repositories.PostRepo;
import com.spring.data_jpa.repositories.UserRepo;
import com.spring.data_jpa.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CreatePostDto createPost(CreatePostDto createPostDto, Integer userId, Integer categoryId) {

        // fetching user
        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new RecordNotFoundException("User", "UserId", userId));

        // fetching category
        Category category = this.categoryRepo.findById(categoryId).
                orElseThrow(()-> new RecordNotFoundException("Category", "Category Id", categoryId));

        // save user's post to database
        // convert PostDto to Post.class
        Post post = this.modelMapper.map(createPostDto, Post.class);
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post createdPost = this.postRepo.save(post);
        return this.modelMapper.map(createdPost, CreatePostDto.class);
    }

    @Override
    public ShowPostDto getPostById(Integer id) {
        Post showPost = this.postRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Post", "Post Id", id));

        return this.modelMapper.map(showPost, ShowPostDto.class);
    }

    @Override
    public List<ShowPostDto> getAllPosts() {
        List<Post> allPost = this.postRepo.findAll();
        return allPost.stream().map(allPosts-> this.modelMapper.map(allPost, ShowPostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostCategoryDto> getAllPostByCategory(Integer categoryId) {

        // fetching category by category id
//        Category category = this.categoryRepo.findById(categoryId).
//                orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        // fetching all post by category
//        List<Post> postCategory = this.postRepo.findByCategory(category);

        // converting entity(postCategory) to PostCategoryDto and returning list
//        return postCategory.stream().map(categoryPost-> this.modelMapper.map(postCategory, PostCategoryDto.class)).toList();
        return List.of();
    }

    @Override
    public List<ShowPostDto> getAllPostByUser(Integer userId) {

        // fetch user by userId
        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new RecordNotFoundException("User", "UserId", userId));

        // fetch post by user
        List<Post> userPost = this.postRepo.findByUser(user);

        // convert Post to ShowPostDto
        return userPost.stream().map(userPosts-> this.modelMapper.map(userPost, ShowPostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowPostDto> searchPost(String keyword) {
        return List.of();
    }

    @Override
    public UpdatePostDto updatePost(UpdatePostDto updatePostDto, Integer id) {
        Post updatedPost = this.postRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Post", "Post Id", id));

        // update post
        updatedPost.setTitle(updatePostDto.getTitle());
        updatedPost.setContent(updatePostDto.getContent());
        updatedPost.setImageName(updatePostDto.getImageName());
//        updatedPost.setCategory(updatePostDto.getCategory());

        return modelMapper.map(updatedPost, UpdatePostDto.class);
    }

    @Override
    public void deletePost(Integer id) {
        Post deletePost = this.postRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Post", "Post Id", id));

//        this.postRepo.delete(deletePost);
        this.postRepo.deleteById(id);
    }
}
