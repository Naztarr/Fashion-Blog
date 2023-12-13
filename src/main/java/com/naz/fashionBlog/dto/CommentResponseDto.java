package com.naz.fashionBlog.dto;

import lombok.Builder;

import java.security.Timestamp;

@Builder
public class CommentResponseDto {

    private String content;
    private Timestamp createdAt;

}
