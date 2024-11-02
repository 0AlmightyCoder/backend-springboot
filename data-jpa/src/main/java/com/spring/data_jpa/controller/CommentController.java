package com.spring.data_jpa.controller;

import com.spring.data_jpa.payload.commentdto.CreateUpdateCommentDto;
import com.spring.data_jpa.payload.commentdto.ShowCommentDto;
import com.spring.data_jpa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    // save Comment to database
    @PostMapping("post/{postId}/create-comment")
    public ResponseEntity<CreateUpdateCommentDto> makeComment(@RequestBody CreateUpdateCommentDto createUpdateCommentDto,
                                                              @PathVariable("postId") Integer postId) {
        CreateUpdateCommentDto saveComment = this.commentService.createComment(createUpdateCommentDto, postId);
        return new ResponseEntity<>(saveComment, HttpStatus.CREATED);
    }

    // get comments from database
    @GetMapping("/get-by-id/{commentId}")
    public ResponseEntity<ShowCommentDto> fetchById(@PathVariable("commentId") Integer commentId) {
        ShowCommentDto showComment = this.commentService.getCommentsById(commentId);
        return ResponseEntity.ok(showComment);
    }

    // get all comments from database
    @GetMapping("/get-all-comments")
    public ResponseEntity<List<ShowCommentDto>> getAllComments() {
        List<ShowCommentDto> commentsList = this.commentService.getAll();
        return ResponseEntity.ok(commentsList);
    }

    // update comment
    @PutMapping("/update-comment/{commentId}")
    public ResponseEntity<CreateUpdateCommentDto> modifyComment(@RequestBody CreateUpdateCommentDto createUpdateCommentDto,
                                                              @PathVariable("commentId") Integer commentId) {
        CreateUpdateCommentDto createUpdate = this.commentService.updateComment(createUpdateCommentDto, commentId);
        return new ResponseEntity<>(createUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<ShowCommentDto> removeComment(@PathVariable("commentId")Integer commentId) {
        ShowCommentDto showCommentDto = this.commentService.getCommentsById(commentId);
        this.commentService.deleteComment(commentId);
        return ResponseEntity.ok(showCommentDto);
    }
}
