package com.naz.fashionBlog.controller;

import com.naz.fashionBlog.dto.AdminRequestDto;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin-signup")
    public ResponseEntity<ApiResponse> signUp(@RequestBody AdminRequestDto adminRequestDto){
        ApiResponse response = adminService.signUp(adminRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("/admin-login")
    public ResponseEntity<ApiResponse> login(@RequestBody AdminRequestDto adminRequestDto){
        ApiResponse response = adminService.login(adminRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
