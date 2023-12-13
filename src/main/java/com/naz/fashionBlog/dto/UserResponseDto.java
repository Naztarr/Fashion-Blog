package com.naz.fashionBlog.dto;

import lombok.Builder;

@Builder
public class UserResponseDto {

    private Long id;

    private String userName;

    private String email;

    private String passWord;
}
