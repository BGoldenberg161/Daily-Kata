package com.smt.kata.data;

// JDK 11.x
import java.io.InvalidObjectException;
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> CharacterMapping.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Character Mapping
 * Given a mapping of digits to letters (as in a phone number), and a digit 
 * character, return all possible letters the number could represent. You can assume 
 * each valid number in the mapping is a single digit.
 * 
 * For example if {2: ['a', 'b', 'c'], 3: ['d', 'e', 'f'], …} then '23' 
 * should return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * You may use java.util.Map and any of it's implementing classes.  No other 
 * collections may be used or anything other than the standard java imports
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class CharacterMapping {
	
	protected Map<Integer, char[]> digitMap;

	/**
	 * Constructor assigns amp
	 * @param digitMap The digit make to work against
	 */
	public CharacterMapping(Map<Integer, char[]> digitMap) throws InvalidObjectException {
		super();

		if(digitMap == null || digitMap.isEmpty()) {
            throw new InvalidObjectException("Null or empty");
        }
		
		this.digitMap = digitMap;
	}

	/**
	 * Adds (concatenates) the elements in the provided locations
	 * @param locations Locations to concatenate
	 * @return concatenated string array
	 */
	 public String[] add(int[] locations) {
	 	// get longest length
        int length = 0;
        for (int i : locations) {
        	//skip nulls
            if (digitMap.get(i) == null) {
            	continue;
            }
            // update length if greater
            if (length < digitMap.get(i).length) {
            	length = digitMap.get(i).length;
            }
        }
        // setup output strings array
        String[] output = new String[length];
        
        // for each int in locations
        for (int i : locations) {
        	// skip nulls
            if (digitMap.get(i) == null) {
            	continue;
            }
            // add letters to strings
            for (int j = 0; j < digitMap.get(i).length; j++) {
            	//create empty string in each location
                if (output[j] == null) {
                	output[j] = "";
                }
                //add letter
                output[j] += digitMap.get(i)[j];
            }
        }
        return output;
    }
}
