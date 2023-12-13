package com.naz.fashionBlog.controller;

import com.naz.fashionBlog.dto.UserRequestDto;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user-signup")
    public ResponseEntity<ApiResponse> signUp(@RequestBody UserRequestDto userRequestDto){
        ApiResponse response = userService.signUp(userRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("/user-login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserRequestDto userRequestDto){
        ApiResponse response = userService.login(userRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
