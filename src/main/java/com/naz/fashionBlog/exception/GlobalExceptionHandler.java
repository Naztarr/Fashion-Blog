package com.naz.fashionBlog.exception;

import com.naz.fashionBlog.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ApiResponse> handleNotFoundException(Exception e){
        ApiResponse response = new ApiResponse("An unknown error",false,HttpStatus.INTERNAL_SERVER_ERROR);
        log.error(e.getMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(InternalError.class)
    protected ResponseEntity<ApiResponse> handleInternalError(Exception e){
        ApiResponse response = new ApiResponse(e.getMessage(),false,HttpStatus.NOT_FOUND);
        log.error(e.getMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
