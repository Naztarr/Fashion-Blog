package com.naz.fashionBlog.service.serviceImplementation;

import com.naz.fashionBlog.dto.PostRequestDto;
import com.naz.fashionBlog.dto.PostResponseDto;
import com.naz.fashionBlog.entity.Post;
import com.naz.fashionBlog.repository.PostRepository;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImplementation implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper mapper = new ModelMapper();

    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
   public ApiResponse createPost(PostRequestDto postRequestDto){
        Post post = mapper.map(postRequestDto, Post.class);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
        log.info("created post successfully"+post);
        return new ApiResponse("post created", true, post, HttpStatus.CREATED);
    }
    @Override
   public ApiResponse updatePost(Long id, PostRequestDto postRequestDto){
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isPresent()){
            Post post = mapper.map(postRequestDto, Post.class);
            post.setUpdatedAt(LocalDateTime.now());
            postRepository.save(post);
            log.info("updated post successfully"+post);
            return new ApiResponse("post updated", true, post, HttpStatus.OK);
        } else{
       return new ApiResponse("post not found", false, HttpStatus.NOT_FOUND);
         }
    }
    @Override
   public ApiResponse getAllPosts(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> listOfPost = posts.getContent();
        List<PostResponseDto> listOfPostDto = listOfPost.stream()
                .map(post -> mapper.map(post, PostResponseDto.class)).collect(Collectors.toList());
        return new ApiResponse("posts retrieved", true, listOfPostDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse searchPostsByCategory(String category, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> posts = postRepository.findByCategory(category, pageable);
        List<Post> listOfPost = posts.getContent();
        List<PostResponseDto> listOfPostDto = listOfPost.stream()
                .map(post -> mapper.map(post, PostResponseDto.class)).collect(Collectors.toList());
        return new ApiResponse("Posts retrieved by category", true, listOfPostDto, HttpStatus.OK);
    }

    @Override
   public ApiResponse deletePost(Long id){
        postRepository.deleteById(id);
        return new ApiResponse("post deleted", true, HttpStatus.OK);
    }
}
