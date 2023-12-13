package com.naz.fashionBlog.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PostResponseDto {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String category;
}
