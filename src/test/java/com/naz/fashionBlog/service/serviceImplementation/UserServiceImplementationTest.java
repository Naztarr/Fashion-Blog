package com.naz.fashionBlog.service.serviceImplementation;

import com.naz.fashionBlog.dto.UserRequestDto;
import com.naz.fashionBlog.entity.Users;
import com.naz.fashionBlog.repository.UserRepository;
import com.naz.fashionBlog.response.ApiResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplementationTest {

    private Users users;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImplementation userService;

    @BeforeEach
    void setUp() {
        users = users.builder()
                .userName("username")
                .email("myEmail@gmail.com")
                .passWord("password")
                .build();
    }

    @Test
    void signUp() {
        UserRequestDto userDto = new UserRequestDto();
        userDto.setUserName(users.getUserName());
        userDto.setEmail(users.getEmail());
        userDto.setPassWord(users.getPassWord());

        when(userRepository.findByUserName(userDto.getUserName())).thenReturn(null);
        when(userRepository.save(Mockito.any(Users.class))).thenReturn(users);

        ApiResponse response = userService.signUp(userDto);
        Assertions.assertThat(response).isNotNull();
        assertEquals("Congratulations! you have successfully signed up", response.getMessage());
        assertEquals(true, response.isSuccess());
        assertEquals(HttpStatus.OK, response.getStatus());

    }

    @Test
    void login() {
    }
}