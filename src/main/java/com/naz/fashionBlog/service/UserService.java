package com.naz.fashionBlog.service;

import com.naz.fashionBlog.dto.AdminRequestDto;
import com.naz.fashionBlog.dto.UserRequestDto;
import com.naz.fashionBlog.response.ApiResponse;

public interface UserService {

    ApiResponse signUp(UserRequestDto userRequestDto);
    ApiResponse login(UserRequestDto userRequestDto);

}
