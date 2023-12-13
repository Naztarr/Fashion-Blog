package com.naz.fashionBlog.repository;

import com.naz.fashionBlog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostById(Long id);
    Page<Post> findByCategory(String category, Pageable pageable);
}
