package com.spring.data_jpa.service.Impl;

import com.spring.data_jpa.entity.Comment;
import com.spring.data_jpa.entity.Post;
import com.spring.data_jpa.exceptions.RecordNotFoundException;
import com.spring.data_jpa.payload.commentdto.CreateUpdateCommentDto;
import com.spring.data_jpa.payload.commentdto.ShowCommentDto;
import com.spring.data_jpa.repositories.CommentRepo;
import com.spring.data_jpa.repositories.PostRepo;
import com.spring.data_jpa.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CreateUpdateCommentDto createComment(CreateUpdateCommentDto createUpdateCommentDto, Integer postId) {

        // fetching posts by id
        Post findPost = this.postRepo.findById(postId).
                orElseThrow(()-> new RecordNotFoundException("Post", "PostId", postId));

        // get comments from AddCommentDto to entity (Comment)
        Comment comment = this.modelMapper.map(createUpdateCommentDto, Comment.class);
        comment.setPost(findPost);

        // save comment in database
        Comment saveComment = this.commentRepo.save(comment);
        return this.modelMapper.map(saveComment, CreateUpdateCommentDto.class);
    }

    @Override
    public ShowCommentDto getCommentsById(Integer id) {
        Comment comment = this.commentRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Comment", "Comment id", id));
        return this.modelMapper.map(comment, ShowCommentDto.class);
    }

    @Override
    public List<ShowCommentDto> getAll() {
        List<Comment> getAll = this.commentRepo.findAll();
        return getAll.stream().map((allComment)-> modelMapper.map(allComment, ShowCommentDto.class)).collect(Collectors.toList());
    }

    @Override
    public CreateUpdateCommentDto updateComment(CreateUpdateCommentDto createUpdateCommentDto, Integer id) {
        // get comment by id
        Comment comment = this.commentRepo.findById(id).
                orElseThrow(()-> new RecordNotFoundException("Comment", "Comment id", id));

        // update comment
        comment.setComment(createUpdateCommentDto.getComment());
        Comment saveComment = this.commentRepo.save(comment);
        return this.modelMapper.map(saveComment, CreateUpdateCommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).
                orElseThrow(()-> new RecordNotFoundException("Comment", "Comment Id", commentId));
        this.commentRepo.deleteById(commentId);
    }
}
