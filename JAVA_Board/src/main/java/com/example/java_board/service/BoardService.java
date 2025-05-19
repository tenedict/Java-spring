package com.example.java_board.service;

import com.example.java_board.domain.Board;
import com.example.java_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 서비스 계층이라는 것을 스프링에 아려주느 것
@RequiredArgsConstructor // Lombok이 제공함 생성자를 자동으로 만들어준다.
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 조회
    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    // ID로 찾기
    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    // 만들기
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }
    
    // 수정하기
    public Board updateBoard(Long id, Board updatedBoard) {
        return boardRepository.findById(id)
            .map(board -> {
                board.setTitle(updatedBoard.getTitle());
                board.setContent(updatedBoard.getContent());
                return boardRepository.save(board);
        })
        .orElseThrow(() -> new IllegalArgumentException("Board not found with id: " + id));
    }


    // 삭제하기
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
