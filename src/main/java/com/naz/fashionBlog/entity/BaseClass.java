package com.naz.fashionBlog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseClass {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@CreationTimestamp
@Column(name = "created_at")
private LocalDateTime createdAt;
@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;
}
