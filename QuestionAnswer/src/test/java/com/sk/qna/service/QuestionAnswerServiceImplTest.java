package com.sk.qna.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sk.qna.QnAApplication;
import com.sk.qna.dataaccessobject.QuestionRepository;
import com.sk.qna.dataobject.Answer;
import com.sk.qna.dataobject.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = QnAApplication.class, 
initializers = ConfigFileApplicationContextInitializer.class)
public class QuestionAnswerServiceImplTest {

	@Autowired
	QuestionAnswerService service;
	
	@Mock
	QuestionRepository repo;
	
	@Before
	public void setup() {
		Question question=createUserEntity();
		repo.save(question);
	}
	
	private Question createUserEntity() {
		Question question= new Question();
		question.setQuestion("question1");
		Answer answer=new Answer();
		answer.setAnswer("answer1");
		Set<Answer> set= new HashSet<>();
		set.add(answer);
		return question;
	}
	
	@Test
	public void testGetAnswers() {
		Question q= createUserEntity();
		Mockito.when(repo.findByQuestion("question1")).thenReturn(Optional.ofNullable(q));
		List<String> answers=service.getAnswers("question1");
		assertNotNull(answers);
		assertEquals(1, answers.size());
	}
	
	@Test 
	public void addQuestionTest() {
		Question q= createUserEntity();
		Mockito.when(repo.save(q)).thenReturn(q);
		Mockito.when(repo.findByQuestion("question1")).thenReturn(Optional.ofNullable(q));
		service.addQuestion("question1", "answer1");
		List<String> answers=service.getAnswers("question1");
		assertNotNull(answers);
		assertEquals(1, answers.size());
		
	}
}
