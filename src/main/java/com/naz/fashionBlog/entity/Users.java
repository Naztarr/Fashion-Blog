package com.naz.fashionBlog.entity;

import com.naz.fashionBlog.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    private String email;

    private String passWord;

    @Enumerated(EnumType.STRING)
    private Status status;
}
