package com.naz.fashionBlog.service;

import com.naz.fashionBlog.dto.CommentRequestDto;
import com.naz.fashionBlog.dto.PostRequestDto;
import com.naz.fashionBlog.response.ApiResponse;

public interface CommentService {

    ApiResponse createComment(CommentRequestDto commentRequestDto);
    ApiResponse updateComment(Long id, CommentRequestDto commentRequestDto);
    ApiResponse getAllComments(int pageNumber, int pageSize);
    ApiResponse deleteComment(Long id);
}
