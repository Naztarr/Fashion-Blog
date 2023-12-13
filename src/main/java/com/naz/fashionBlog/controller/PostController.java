package com.naz.fashionBlog.controller;

import com.naz.fashionBlog.dto.PostRequestDto;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<ApiResponse> createPost(@RequestBody PostRequestDto postRequestDto){
        ApiResponse response = postService.createPost(postRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/post-update")
    public ResponseEntity<ApiResponse> updatePost(@PathVariable Long id,
                                                  @RequestBody PostRequestDto postRequestDto){
        ApiResponse response = postService.updatePost(id, postRequestDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/all-posts")
    public ResponseEntity<ApiResponse> getAllPosts(@RequestParam("pageNumber") int pageNumber,
                                                   @RequestParam("pageSize") int pageSize){
        ApiResponse response = postService.getAllPosts(pageNumber, pageSize);
        return new ResponseEntity<>(response, response.getStatus());
    }


    @GetMapping("/categorized-posts")
    public ResponseEntity<ApiResponse> searchPostsByCategory(@RequestParam("category") String category,
                                                   @RequestParam("pageNumber") int pageNumber,
                                                   @RequestParam("pageSize") int pageSize){
        ApiResponse response = postService.searchPostsByCategory(category, pageNumber, pageSize);
        return new ResponseEntity<>(response, response.getStatus());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long id){
        ApiResponse response = postService.deletePost(id);
        return new ResponseEntity<>(response, response.getStatus());
    }
}

