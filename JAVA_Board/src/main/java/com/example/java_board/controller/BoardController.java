package com.example.java_board.controller;

import com.example.java_board.service.BoardService;
import com.example.java_board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")

public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getBoardList() {
        return boardService.getAllBoard();
    }

    @GetMapping("/{id}")
    public Optional<Board> getBoard(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }


    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody Board updatedBoard) {
        return boardService.updateBoard(id, updatedBoard);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
