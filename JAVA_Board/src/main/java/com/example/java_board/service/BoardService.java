package com.example.java_board.service;

import com.example.java_board.domain.Board;
import com.example.java_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board updateBoard(Long id, Board updatedBoard) {
        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(updatedBoard.getTitle());
                    board.setContent(updatedBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseThrow(() -> new IllegalArgumentException("Board not found with id: " + id));
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}