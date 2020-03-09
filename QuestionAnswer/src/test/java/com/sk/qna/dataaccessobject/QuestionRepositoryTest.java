package com.sk.qna.dataaccessobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sk.qna.QnAApplication;
import com.sk.qna.dataobject.Answer;
import com.sk.qna.dataobject.Question;

/**
 * 
 * @author sdagur
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = QnAApplication.class, 
initializers = ConfigFileApplicationContextInitializer.class)
public class QuestionRepositoryTest {

	@Autowired
	QuestionRepository repository;
	
	@Test
	public void TestRepositoryInjected() {
		assertNotNull(repository);
	}
	
	@Test
	public void testSave() {
		Question question = createUserEntity();
		repository.save(question);
		Optional<Question> q=repository.findByQuestion("question1");
		Question qq=q.get();
		assertEquals("question1", qq.getQuestion());
		repository.flush();
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
}
