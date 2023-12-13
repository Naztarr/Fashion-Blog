package com.naz.fashionBlog.controller;

import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/post-like/{postId}")
    public ResponseEntity<ApiResponse> likeOrUnlikePost(@PathVariable Long postId,
                                                @RequestParam("userId")Long userId,
                                                @RequestParam("likeAction") boolean likeAction){
        ApiResponse response = likeService.likeOrUnlikePost(postId, userId, likeAction);
        return new ResponseEntity<>(response, response.getStatus());
    }


}











//
//@PostMapping("/post-unlike")
//    public ResponseEntity<ApiResponse> unlikePost(@PathVariable Long postId, @PathVariable Long userId){
//        ApiResponse response = likeService.unlikePost(postId, userId, likeAction);
//        return new ResponseEntity<>(response, response.getStatus());