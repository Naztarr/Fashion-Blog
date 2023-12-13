package com.naz.fashionBlog.dto;

import com.naz.fashionBlog.entity.Post;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequestDto {


    private String userName;
    private String email;
    private String passWord;

}
