package com.naz.fashionBlog.service;

import com.naz.fashionBlog.dto.AdminRequestDto;
import com.naz.fashionBlog.response.ApiResponse;

public interface AdminService {

    ApiResponse signUp(AdminRequestDto adminRequestDto);
    ApiResponse login(AdminRequestDto adminRequestDto);
}
