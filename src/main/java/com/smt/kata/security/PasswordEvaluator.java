package com.smt.kata.security;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: PasswordEvaluator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Evaluates a password to be complete with the following rules:
 * 
 * Must have at least 1 lower case
 * Must have at least 1 upper case
 * Must have at least 1 digit
 * Must have at least 1 special character (any non-alpha numeric character is fine)
 * Must be at least as long as the provided minimum length
 * 
 * Additionally, you may NOT use regexes.  You must do this evaluation as a single
 * line code set using lambdas and streams.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class PasswordEvaluator {

	/**
	 * Evaluates that a password meets the requirements for a valid password
	 * @param password Password to be evaluated
	 * @param minLength Minimum length of the password
	 * @return True if the password matches all of the rules.  False otherwise
	 */
	public boolean isValidPassword(String password, int minLength) {
		
		return password.length() < minLength ? false : 
			Arrays.stream(password.split("")).anyMatch(s -> Character.isLowerCase(s.charAt(0))) &&
			Arrays.stream(password.split("")).anyMatch(s -> Character.isUpperCase(s.charAt(0))) &&
			Arrays.stream(password.split("")).anyMatch(s -> Character.isDigit(s.charAt(0))) &&
			Arrays.stream(password.split("")).anyMatch(s -> !Character.isDigit(s.charAt(0)) && !Character.isLetter(s.charAt(0)));
	}

}
