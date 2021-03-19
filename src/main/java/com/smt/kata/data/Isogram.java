package com.smt.kata.data;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: Isogram.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Isograms
 *
 * Determine if a word or phrase is an isogram.
 * 
 * Use the Unit Test to determine the rules for an Isogram
 * 
 * You MAY not use collections or anything other than primitives and Strings for this exercise
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 17, 2021
 * @updates:
 ****************************************************************************/
public class Isogram {

	/**
	 * Validates whether or not the phrase is an isogram
	 * @param phrase Phrase to check against the Isogram rules
	 * @return true if an isogram.  False if empty or not an isogram
	 */
	public boolean isValidIsogram(String phrase) {
<<<<<<< HEAD
		if (StringUtils.isEmpty((phrase))){
            return false;
        }
		
		phrase = phrase.toLowerCase().replace(" ", "-");
		System.out.println(phrase);
		
		String temp = "";
		for(int i = 0; i < phrase.length(); i++) {
			
			char letter = phrase.charAt(i);
			
			if(temp.contains(Character.toString(letter))) {
				return false;
			}else if(letter != '-') {
				temp += Character.toString(letter);
				System.out.println(temp);
			}
			
		}
		
		return true;
	}
=======
        
        return phrase == null;
    }
>>>>>>> 2301c10c22086818251918614b989e44c08a9b12
}
