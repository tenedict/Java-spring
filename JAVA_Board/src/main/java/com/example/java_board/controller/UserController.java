package com.example.java_board.controller;

import com.example.java_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입 POST 요청 처리
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        userService.register(username, password);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }
}