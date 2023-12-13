package com.naz.fashionBlog.service.serviceImplementation;

import com.naz.fashionBlog.dto.UserRequestDto;
import com.naz.fashionBlog.entity.Users;
import com.naz.fashionBlog.repository.UserRepository;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper = new ModelMapper();

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
   public ApiResponse signUp(UserRequestDto userRequestDto){
        if(userRepository.findByUserName(userRequestDto.getUserName()) != null){
            return new ApiResponse("User with the username you provided already exists", false, HttpStatus.BAD_REQUEST);
        } else if(!userRequestDto.getEmail().matches("^[A-Za-z0-9+_.-]+@[a-z]+\\.com$")){
            return new ApiResponse("invalid email format", false, HttpStatus.BAD_REQUEST);
        } else if(userRequestDto.getPassWord().length()<8){
            return new ApiResponse("password must not be less than 8 digits", false, HttpStatus.BAD_REQUEST);
        } else{
            Users users = mapper.map(userRequestDto, Users.class);
            userRepository.save(users);
            return new ApiResponse("Congratulations! you have successfully signed up", true, HttpStatus.OK);
        }
    }
    @Override
    public ApiResponse login(UserRequestDto userRequestDto){
        String userName = userRequestDto.getUserName();
        String passWord = userRequestDto.getPassWord();
        Users users = userRepository.findByUserName(userName);
        if(users == null){
            return new ApiResponse("You have not signed up on this platform yet", false, HttpStatus.UNAUTHORIZED);
        } else if(!users.getPassWord().equals(passWord)){
            return new ApiResponse("Incorrect password", false, HttpStatus.BAD_REQUEST);
        } else{
            return new ApiResponse("successfully logged in", true, HttpStatus.OK);
        }
    }
}
