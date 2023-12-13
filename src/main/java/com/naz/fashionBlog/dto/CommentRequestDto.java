package com.naz.fashionBlog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {

    private String content;
    private Timestamp createdAt;

}
