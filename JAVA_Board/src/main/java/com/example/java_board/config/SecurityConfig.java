package com.example.java_board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (API 서버라면 보통 이렇게 함)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register", "/users/login").permitAll()// 회원가입, 로그인은 인증 없이 허용
                        .requestMatchers("/boards").permitAll() // 자료 뭐있는지 보는거
                        .anyRequest().authenticated() // 나머지는 인증 필요
                )
                .formLogin(withDefaults()); // 기본 로그인 폼 활성화 (나중에 JWT 쓸 때 바꿀 수 있음)

        return http.build();
    }
}