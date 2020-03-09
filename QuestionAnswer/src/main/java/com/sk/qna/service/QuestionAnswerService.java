package com.sk.qna.service;

import java.util.List;

import com.sk.qna.dataobject.Question;

/**
 * 
 * @author sdagur
 *
 */
public interface QuestionAnswerService {
	
	public void addQuestion(String question,String answers);
	public List<String> getAnswers(String question);
	
	Question save(Question t) throws Exception;
	

}
