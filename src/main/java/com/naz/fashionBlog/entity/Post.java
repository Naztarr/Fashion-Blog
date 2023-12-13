package com.naz.fashionBlog.entity;


import com.naz.fashionBlog.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post extends BaseClass{
    private String title;
    private String description;
    private String imageUrl;
    private String category;
    @ManyToOne
    @JoinColumn(
            name = "admin_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "post_admin_key")
    )
    private Admin admin;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "post", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Like> likes;

}
