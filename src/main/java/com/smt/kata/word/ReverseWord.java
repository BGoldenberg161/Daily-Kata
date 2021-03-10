package com.smt.kata.word;

import java.util.*;
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: ReverseWord.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * 
 * Examples
 * reverseWords("the sky is blue") ➞ "blue is sky the"
 * 
 * reverseWords("  hello world!  ") ➞ "world! hello"
 * 
 * reverseWords("a good   example") ➞ "example good a"
 * Notes
 * A word is defined as a sequence of non-space characters.
 * The input string may contain leading or trailing spaces. However, your reversed 
 * string should not contain leading or trailing spaces. You need to reduce multiple 
 * spaces between two words to a single space in the reversed string. You *** MAY NOT ***
 * utilize String.split() or parsing methods.  You must loop the phrase and process in a 
 * loop.  You may use collections to store words if desired.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class ReverseWord {

	/**
	 * 
	 */
	public ReverseWord() {
		super();
	}
	
	/**
	 * Takes the phrase and reverses the ords
	 * @param phrase
	 * @return
	 */
	public String processPhrase(String phrase) {
		if(StringUtils.isEmpty(phrase)) {
			return "";
		}
		
		String trimmed = phrase.trim();
		String word = "";

		List<String> words=new ArrayList<String>();
		
//		String[] words = phrase.split(" ");
		for(int j = 0; j < trimmed.length(); j++) {
            char letter = trimmed.charAt(j);
            if(letter == ' ') {
                if(word.length() > 0)
                    words.add(word);
                word = "";
            }else {
                word += letter;
            }
        }
        words.add(word);
		
		String result = "";
		
		for(int i = 0; i < words.size(); i++) {
			if(i == 0) {
				result = words.get(i);
			}else {
				result = words.get(i) + " " + result;
			}
			System.out.println(result);
		}
		return result;
	}
}
