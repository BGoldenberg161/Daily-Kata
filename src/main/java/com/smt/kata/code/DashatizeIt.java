package com.smt.kata.code;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DashatizeIt.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Dashatize It
 * 
 * Given a variable n,
 * 
 * If n is an integer, Return a string with dash'-'marks before and after each
 * odd integer, but do not begin or end the string with a dash mark. If n is
 * negative, then the negative sign should be removed.
 * 
 * If n is not an integer, return an empty value.
 * 
 * Ex:
 * dashatize(274) -> '2-7-4' 
 * dashatize(6815) -> '68-1-5'
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class DashatizeIt {

	/**
	 * Formats the string of numbers into a Dashatize format
	 * @param input String to be processed.  All non numeric characters are omitted
	 * @return Formatted string.  Empty string if input is empty or null
	 */
    public String process(String input) {
    	if(StringUtil.isEmpty(input)) return "";
    	
    	String result = "";
    	boolean wasOdd = false;
    	
    	for (int i = 0; i < input.length(); i++) {
    		char current = input.charAt(i);
    		if (Character.isDigit(current)) {
    			if (Integer.valueOf(current) % 2 != 0) {
    				if(result.length() != 0) {
    					result += "-" + Character.toString(current);
    				} else {
    					result += Character.toString(current);
    				}
    				wasOdd = true;
    			} else {
    				if(wasOdd) result += "-";
    				result += Character.toString(current);
    				wasOdd = false;
    			}
    		}
    	}
    	System.out.println(result);
    	
    	return result;
    }
}
