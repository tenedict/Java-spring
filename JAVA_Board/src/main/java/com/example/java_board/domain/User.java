package com.example.java_board.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // id를 제외한 생성자 직접 선언 (id는 DB가 자동생성)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}