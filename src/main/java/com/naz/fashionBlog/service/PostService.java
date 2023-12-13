package com.naz.fashionBlog.service;

import com.naz.fashionBlog.dto.PostRequestDto;
import com.naz.fashionBlog.response.ApiResponse;

public interface PostService {

    ApiResponse createPost(PostRequestDto postRequestDto);
    ApiResponse updatePost(Long id, PostRequestDto postRequestDto);
    ApiResponse getAllPosts(int pageNumber, int pageSize);

    ApiResponse searchPostsByCategory(String category, int pageNumber, int pageSize);

    ApiResponse deletePost(Long id);
}
