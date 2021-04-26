package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title:</b> PhoneNumberDecoder.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> Phone Number Word Decoder
 * 
 * Create a program that converts a phone number with letters to one with only numbers.
 * Examples
 * 
 * textToNum("123-647-EYES") ➞  "123.647.3937"
 * textToNum("(325)444-TEST") ➞ "325.444.8378"
 * textToNum("653-TRY-THIS") ➞  "653.879.8447"
 * textToNum("435-224-7613") ➞  "435.224.7613"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class PhoneNumberDecoder {

	Map<String, Integer> numbers = new HashMap<>();
	
	/**
	 * 
	 */
	public PhoneNumberDecoder() {
        super();
        numbers.put("A", 2);
        numbers.put("B", 2);
        numbers.put("C", 2);
        numbers.put("D", 3);
        numbers.put("E", 3);
        numbers.put("F", 3);
        numbers.put("G", 4);
        numbers.put("H", 4);
        numbers.put("I", 4);
        numbers.put("J", 5);
        numbers.put("K", 5);
        numbers.put("L", 5);
        numbers.put("M", 6);
        numbers.put("N", 6);
        numbers.put("O", 6);
        numbers.put("P", 7);
        numbers.put("Q", 7);
        numbers.put("R", 7);
        numbers.put("S", 7);
        numbers.put("T", 8);
        numbers.put("U", 8);
        numbers.put("V", 8);
        numbers.put("W", 9);
        numbers.put("X", 9);
        numbers.put("Y", 9);
        numbers.put("Z", 9);
    }

    /**
     * Converts a phone number with text to a formatted phone number
     * @param pn phone number to parse
     * @return formatted phone number.
     */
    public String textToNum(String pn) {
        if(StringUtils.isEmpty(pn)) {
            return "";
        }
        
        pn = pn.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        
        if(pn.length() != 10) {
            return "";
        }

        String result = "";

        for(char c : pn.toCharArray()) {
        	if(!Character.isDigit(c)) {
        		String letter = String.valueOf(c);
        		result += (numbers.get(letter));
        	}else {
        		result += (c - '0');
        	}
        }
        
        result = String.format("%s.%s.%s", result.substring(0, 3), result.substring(3, 6), result.substring(6));
        
        return result;
    }
}
