package com.naz.fashionBlog.service;

import com.naz.fashionBlog.response.ApiResponse;

public interface LikeService {

    ApiResponse likeOrUnlikePost(Long postId, Long userId, boolean likeAction);
//    ApiResponse unlikePost(Long postId, Long userId, boolean likeAction);
}
