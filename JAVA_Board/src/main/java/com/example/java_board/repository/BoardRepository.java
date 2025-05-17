package com.example.java_board.repository;
import com.example.java_board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 보드는 무이가 지정할 대상 엔티티, Long은 id가 Long이기 때문

//    	•	save() - 저장
//	•	findById() - ID로 조회
//	•	findAll() - 전체 조회
//	•	deleteById() - 삭제
}

