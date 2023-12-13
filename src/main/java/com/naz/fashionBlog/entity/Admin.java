package com.naz.fashionBlog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;
    private String email;
    private String passWord;
//    @OneToMany(mappedBy = "admin", orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Post> posts;
}
