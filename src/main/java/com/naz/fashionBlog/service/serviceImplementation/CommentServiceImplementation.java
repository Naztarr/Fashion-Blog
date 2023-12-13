package com.naz.fashionBlog.service.serviceImplementation;

import com.naz.fashionBlog.dto.CommentRequestDto;
import com.naz.fashionBlog.dto.CommentResponseDto;
import com.naz.fashionBlog.dto.PostRequestDto;
import com.naz.fashionBlog.entity.Comment;
import com.naz.fashionBlog.repository.CommentRepository;
import com.naz.fashionBlog.response.ApiResponse;
import com.naz.fashionBlog.service.CommentService;
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

@Service
public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper mapper = new ModelMapper();

    public CommentServiceImplementation(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
   public ApiResponse createComment(CommentRequestDto commentRequestDto){
        Comment comment = mapper.map(commentRequestDto, Comment.class);
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return new ApiResponse("comment created", true, comment, HttpStatus.CREATED);
    }
    @Override
   public ApiResponse updateComment(Long id, CommentRequestDto commentRequestDto){
        Optional<Comment> commentOptional = (commentRepository.findById(id));
        if(commentOptional.isPresent()){
            Comment comment = mapper.map(commentRequestDto, Comment.class);
            comment.setUpdatedAt(LocalDateTime.now());
            commentRepository.save(comment);
            return new ApiResponse("comment updated", true, comment, HttpStatus.OK);
        } else{
            return new ApiResponse("comment not found", false, HttpStatus.NOT_FOUND);
        }
    }
    @Override
   public ApiResponse getAllComments(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Comment> comments = commentRepository.findAll(pageable);
        List<Comment> listOfComment = comments.getContent();
        List<CommentResponseDto> listOfCommentDto = listOfComment.stream()
                .map(comment -> mapper.map(comment, CommentResponseDto.class)).collect(Collectors.toList());
        return new ApiResponse("comments retrieved", true, listOfCommentDto, HttpStatus.OK);
    }
    @Override
   public ApiResponse deleteComment(Long id){
        commentRepository.deleteById(id);
        return new ApiResponse("comment deleted", true, HttpStatus.OK);
    }
}
