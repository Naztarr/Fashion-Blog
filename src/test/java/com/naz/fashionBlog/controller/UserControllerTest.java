package com.naz.fashionBlog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naz.fashionBlog.dto.UserRequestDto;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void signUp() throws Exception {
        UserRequestDto userDto = new UserRequestDto();
        userDto.setUserName("username");
        userDto.setEmail("myEmail@gmail.com");
        userDto.setPassWord("password");

        ApiResponse successResponse = new ApiResponse("Congratulations! You have successfully signed up", true, HttpStatus.OK);
        when(userService.signUp(any(UserRequestDto.class))).thenReturn(successResponse);

        MvcResult result = mockMvc.perform(post("/user-signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andReturn();

        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(result.getResponse().getStatus(), 200);

    }

    @Test
    void signUpWhenUserAlreadyExists() throws Exception {
        UserRequestDto userDto = new UserRequestDto();
        userDto.setUserName("username");
        userDto.setEmail("myEmail@gmail.com");
        userDto.setPassWord("password");

        ApiResponse userExists = new ApiResponse("User with the username you provided already exists", false, HttpStatus.BAD_REQUEST);
        when(userService.signUp(any(UserRequestDto.class))).thenReturn(userExists);

        MvcResult result = mockMvc.perform(post("/user-signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andReturn();

        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(result.getResponse().getStatus(), 400);

    }

    @Test
    void login() {
    }
}