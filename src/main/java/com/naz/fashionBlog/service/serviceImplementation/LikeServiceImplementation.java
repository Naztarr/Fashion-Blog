package com.naz.fashionBlog.service.serviceImplementation;

import com.naz.fashionBlog.entity.Like;
import com.naz.fashionBlog.entity.Post;
import com.naz.fashionBlog.entity.Users;
import com.naz.fashionBlog.repository.LikeRepository;
import com.naz.fashionBlog.repository.PostRepository;
import com.naz.fashionBlog.repository.UserRepository;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImplementation implements LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public LikeServiceImplementation(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse likeOrUnlikePost(Long postId, Long userId, boolean likeAction) {
        Optional<Users> userOptional = userRepository.findById(userId);
        Optional<Post> postOptional = postRepository.findById(postId);

        if (userOptional.isPresent() && postOptional.isPresent()) {
            Users users = userOptional.get();
            Post post = postOptional.get();

            Like like = likeRepository.findLikeByUsersAndPost(users, post);

            if (likeAction) { // Like action
                if (like == null) {
                    like = new Like();
                    like.setPost(post);
                    likeRepository.save(like);
                    return new ApiResponse("You have liked a post", true, HttpStatus.OK);
                } else {
                    return new ApiResponse("Post already liked", false, HttpStatus.BAD_REQUEST);
                }
            } else { // Unlike action
                if (like != null) {
                    likeRepository.delete(like);
                    return new ApiResponse("You have unliked a post", true, HttpStatus.OK);
                } else {
                    return new ApiResponse("Post was not liked", false, HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            return new ApiResponse("User or Post not found", false, HttpStatus.NOT_FOUND);
        }
    }

}























//    @Override
//    public ApiResponse likePost(Long postId, Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Optional<Post> postOptional = postRepository.findById(postId);
//
//        if (userOptional.isPresent() && postOptional.isPresent()) {
//            User user = userOptional.get();
//            Post post = postOptional.get();
//
//            Like like = likeRepository.findLikeByUser(user);
//            if (like == null) {
//                like.setPost(post);
//                like.setUser(user);
//                likeRepository.save(like);
//                return new ApiResponse("You have liked a post", true);
//            } else {
//                return new ApiResponse("Post already liked", false);
//            }
//        } else {
//            return new ApiResponse("User or Post not found", false);
//        }
//    }
//
//    @Override
//    public ApiResponse unlikePost(Long postId, Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Optional<Post> postOptional = postRepository.findById(postId);
//
//        if (userOptional.isPresent() && postOptional.isPresent()) {
//            User user = userOptional.get();
//
//            Like like = likeRepository.findLikeByUser(user);
//            if (like != null) {
//                likeRepository.delete(like);
//                return new ApiResponse("You have unliked a post", true);
//            } else {
//                return new ApiResponse("post was not liked", false, HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            return new ApiResponse("User or Post not found", false, HttpStatus.NOT_FOUND);
//        }
//    }