package com.sk.qna.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.qna.dataaccessobject.AnswerRepository;
import com.sk.qna.dataaccessobject.QuestionRepository;
import com.sk.qna.dataobject.Answer;
import com.sk.qna.dataobject.Question;
import com.sk.qna.util.ValidationUtil;

@Service
@Transactional
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

	private static final Logger log = LoggerFactory.getLogger(QuestionAnswerServiceImpl.class);

	@Autowired
	QuestionRepository qRep;
	@Autowired
	AnswerRepository aRepo;

	@Override
	public void addQuestion(String question, String answers) {
		if (answers != null && !answers.isEmpty()) {
			Question ques = new Question();
			ques.setQuestion(question);
			String[] answArr = answers.split("\"");
			Set<Answer> s1 = new HashSet<>();
			for (String answer : answArr) {
				answer = answer.trim();
				if (answer != null && !answer.isEmpty()) {
					boolean validate = ValidationUtil.validateLength(answer);
					if (validate) {
						Answer a1 = new Answer();
						a1.setAnswer(answer);
						s1.add(a1);
					} else {
						System.out.println("Answer length is more than 256 characters for answer " + answer);
					}
				}
			}

			ques.setAnswers(s1);
			try {
				save(ques);
			} catch (Exception e) {
				System.out.println("error: " + e.getMessage());
			}
		} else {
			System.out.println("No answer provided for questions");
		}
	}

	@Override
	public List<String> getAnswers(String question) {
		Optional<Question> question1 = qRep.findByQuestion(question);
		List<String> returnList = new ArrayList<>();
		if (question1.isPresent()) {
			Question q = question1.get();
			List<Answer> aa = q.getAnswers().stream().collect(Collectors.toList());
			for (Answer answer : aa) {
				returnList.add(answer.getAnswer());
			}
		}
		if (returnList.isEmpty()) {
			returnList.add("\"" + "the answer to life, universe and everything is 42" + "\"" + " according to" + "\""
					+ "The hitchhikers guide to the Galaxy" + "\"");
		}
		return returnList;
	}

	@Override
	@Transactional
	public Question save(Question question) throws Exception {
		Question q = qRep.save(question);
		Set<Answer> answers = q.getAnswers();
		for (Answer answer : answers) {
			answer.setQuestion(q);
			aRepo.save(answer);
		}
		return q;
	}

}