package com.naz.fashionBlog.service.serviceImplementation;

import com.naz.fashionBlog.dto.AdminRequestDto;
import com.naz.fashionBlog.entity.Admin;
import com.naz.fashionBlog.repository.AdminRepository;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService {
    private final AdminRepository adminRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public AdminServiceImplementation(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public ApiResponse signUp(AdminRequestDto adminRequestDto){
        if(adminRepository.findByUserName(adminRequestDto.getUserName()) != null){
            return new ApiResponse("User with the username you provided already exists", false, HttpStatus.BAD_REQUEST);
        } else if(!adminRequestDto.getEmail().matches("^[A-Za-z0-9+_.-]+@[a-z]+\\.com$")){
            return new ApiResponse("invalid email format", false, HttpStatus.BAD_REQUEST);
        } else if(adminRequestDto.getPassWord().length()<8){
            return new ApiResponse("password must not be less than 8 digits", false, HttpStatus.BAD_REQUEST);
        } else{
           Admin admin = mapper.map(adminRequestDto, Admin.class);
           adminRepository.save(admin);
            return new ApiResponse("Congratulations! you have successfully signed up", true, HttpStatus.OK);
        }

    }
    @Override
    public ApiResponse login(AdminRequestDto adminRequestDto){
        String userName= adminRequestDto.getUserName();
        String passWord = adminRequestDto.getPassWord();
        Admin admin = adminRepository.findByUserName(userName);
        if(admin == null){
            return new ApiResponse("You have not signed up on this platform yet", false, HttpStatus.UNAUTHORIZED);
        } else if(!admin.getPassWord().equals(passWord)){
            return new ApiResponse("Incorrect password", false, HttpStatus.BAD_REQUEST);
        } else{
            return new ApiResponse("successfully logged in", true, HttpStatus.OK);
        }
    }
}





















/*
* [Sunday 00:15] Chinaza Herbert
regex for email & password verification.
if (userRepository.existsByEmail(userDTO.getEmail())) {
    return ResponseEntity.badRequest().body(new ApiResponse("The email you provided is already in use", false));
} else if (!userEmail.matches("^[A-Za-z0-9+_.-]+@[a-z]+\\.(com|org|net|gov|edu|co\\.uk|io|info)$")) {
    return ResponseEntity.badRequest().body(new ApiResponse("Invalid email format", false));
} else if (userPassword.length() < 8) {
    return ResponseEntity.badRequest().body(new ApiResponse("Password must contain at least 8 characters", false));
} else if (!userPassword.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
    return ResponseEntity.badRequest().body(new ApiResponse("Password must contain at least one special character", false));
} else if (!userPassword.matches(".*[A-Z].*")) {
    return ResponseEntity.badRequest().body(new ApiResponse("Password must contain at least one capital letter", false));
}
 like 4*/
