package com.naz.fashionBlog.repository;

import com.naz.fashionBlog.entity.Like;
import com.naz.fashionBlog.entity.Post;
import com.naz.fashionBlog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    Like findLikeByUsersAndPost(Users users, Post post);
}
