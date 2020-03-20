package com.sk.qna.util;

/**
 * 
 * @author sdagur
 *
 */
public class ValidationUtil {

	public static boolean validateLength(String input) {
		
		if(input==null || input.length()>255) {
			return false;
		}
		return true;
	}
	
	public static boolean validateAnswerFormat(String input) {
		if(input.contains("\"")) {
			return true;
		}
		return false;
	}
	
	public static boolean validateQuestion(String input) {
		if(input==null || input.isEmpty()) {
			return false;
		}
		return true;
	}
}
