package com.naz.fashionBlog.controller;

import com.naz.fashionBlog.dto.CommentRequestDto;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<ApiResponse> createComment(@RequestBody CommentRequestDto commentRequestDto){
        ApiResponse response = commentService.createComment(commentRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/comment-update")
    public ResponseEntity<ApiResponse> updateComment(@PathVariable Long id,
                                                  @RequestBody CommentRequestDto commentRequestDto){
        ApiResponse response = commentService.updateComment(id, commentRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/all-posts")
    public ResponseEntity<ApiResponse> getAllComments(@RequestParam("pageNUmber") int pageNumber,
                                                   @RequestParam("pageSize") int pageSize){
        ApiResponse response = commentService.getAllComments(pageNumber, pageSize);
        return new ResponseEntity<>(response, response.getStatus());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteComments(@PathVariable Long id){
        ApiResponse response = commentService.deleteComment(id);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
