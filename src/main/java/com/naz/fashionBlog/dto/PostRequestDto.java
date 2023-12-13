package com.naz.fashionBlog.dto;

import com.naz.fashionBlog.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {

    private String title;
    private String description;
    private String imageUrl;
    private String category;
}
