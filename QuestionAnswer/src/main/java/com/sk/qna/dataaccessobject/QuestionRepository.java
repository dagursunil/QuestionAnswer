package com.sk.qna.dataaccessobject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.qna.dataobject.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	 @Query(nativeQuery = true, value = "select * from question where question = ?")
	Optional<Question> findByQuestion(String question);
	
}
