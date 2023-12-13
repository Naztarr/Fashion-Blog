package com.naz.fashionBlog.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comment extends BaseClass{

    private String content;
//    @ManyToOne
//    @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "id",
//            foreignKey = @ForeignKey(name = "comment_user_key")
//    )
//    private Users users;
    @ManyToOne
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "comment_post_key")
    )
    private Post post;
}
