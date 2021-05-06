package com.smt.kata.code;

import java.util.ArrayList;
// JDK 11.x
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title:</b> AnagramIndicese.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Anagram Indicie
 * 
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
 * 
 * For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 28, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class AnagramIndices {

	/**
	 * Finds the location of each indices of w in s
	 * @param w characters to find
	 * @param s String to locate w
	 * @return Collection of indices locations.  Empty collection if none found
	 */
	public Collection<Integer> find(String w, String s) {
		//check null
		if(StringUtils.isEmpty(w) || StringUtils.isEmpty(s)) return new ArrayList<>();
		
		//standardize inputs
		s = s.toLowerCase();
		w = w.toLowerCase();
		
		List<Integer> results = new ArrayList<>();
		
		//check forwards
		int location = 0;
		while(location != -1) {
			location = s.indexOf(w, location);
			if(!results.contains(location) && location != -1) {				
				results.add(location);
			}
			if(location != -1) {				
				location++;
			}
			System.out.println(location);
		}
		
		//check backwards
		String wRev = new StringBuilder(w).reverse().toString();
		location= 0;
		while(location != -1) {
			location = s.indexOf(wRev, location);
			if(!results.contains(location) && location != -1) {				
				results.add(location);
			}
			if(location != -1) {				
				location++;
			}
			System.out.println(location);
		}
		
		
		return results;
	}
}
