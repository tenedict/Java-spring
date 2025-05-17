package com.example.java_board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity //JPA로 관리된다
@Getter  // 테이블과 연결될 것 이다.
@Setter
@NoArgsConstructor //기본 생성자 (new Board())자동 생성
@AllArgsConstructor //모든 필드를 받는 생성자 자동 생성
@Builder
// Board.builder().title("제목").content("내용").build() 이런 식으로 만들 수 있게 해줌 (코드 예쁘게 만들기 용!)

public class Board { //게시글 표현하는 클래쓰
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}
