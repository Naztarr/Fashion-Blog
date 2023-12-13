package com.naz.fashionBlog.repository;

import com.naz.fashionBlog.entity.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {
    private final UserRepository userRepository;
    private Users users;

    @Autowired
    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {
        users = users.builder()
                .userName("username")
                .email("myEmail@gmail.com")
                .passWord("password")
                .build();
    }

    @Test
    void saveUser(){
        Users savedUser = userRepository.save(users);
        Assertions.assertThat(savedUser)
                .isNotNull()
                .isEqualTo(users);
        Assertions.assertThat(savedUser.getUserName()).isEqualTo(users.getUserName());
    }

    @Test
    void findByUserName() {
        saveUser();
        Users users1 = userRepository.findByUserName(users.getUserName());
        Assertions.assertThat(users1).isNotNull();
        assertThat(users1).isEqualTo(users);
    }
}