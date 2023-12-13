package com.naz.fashionBlog.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private String message;
    private boolean success;
    private Object data;
    @JsonIgnore
    private HttpStatus status;

    public ApiResponse(String message, boolean success, Object data, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.status = status;

    }

    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;


    }
}
