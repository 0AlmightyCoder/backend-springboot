package com.spring.data_jpa.service;

import com.spring.data_jpa.payload.commentdto.CreateUpdateCommentDto;
import com.spring.data_jpa.payload.commentdto.ShowCommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    // create comment
    CreateUpdateCommentDto createComment(CreateUpdateCommentDto createUpdateCommentDto, Integer postId);

    // get comments by id
    ShowCommentDto getCommentsById(Integer id);

    // get all comments
    List<ShowCommentDto> getAll();

    // update comments
    CreateUpdateCommentDto updateComment(CreateUpdateCommentDto createUpdateCommentDto, Integer id);

    // delete comments
    void deleteComment(Integer commentId);
}
