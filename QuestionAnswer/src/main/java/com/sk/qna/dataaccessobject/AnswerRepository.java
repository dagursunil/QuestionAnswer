package com.sk.qna.dataaccessobject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.qna.dataobject.Answer;



public interface AnswerRepository extends JpaRepository<Answer, Long>{

	 @Query(nativeQuery = true, value = "select * from wallet where question_id = ?")
	List<Answer> findByQustionId(Long questionId);
}
