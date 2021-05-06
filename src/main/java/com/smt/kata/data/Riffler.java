package com.smt.kata.data;

import org.apache.commons.lang3.ArrayUtils;

// Spacelibs 1.x
import com.siliconmtn.data.bean.GenericVO;

/****************************************************************************
 * <b>Title:</b> Riffler.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Riffler
 * 
 * Riffle takes two lists and alternately puts their elements into one list: 
 * 
 * Riffle[{a,b,c},{1,2,3}] 
 * {a,1,b,2,c,3} 
 * 
 * Write a method that implements the riffle.  Note, the source array can be equal
 * in length to the 2nd array.  It can also be one item larger.  Any other scenario 
 * doesn't work
 * 
 * Write a method Deriffle that takes a list of any length and separates it into 
 * two lists. The first list should contain all of the entries with odd indices in 
 * the original list, and the second should contain all of the entries with even indices. 
 * 
 * Deriffle[{1,2,3,4,5}] 
 * {{1,3,5},{2,4}}
 * 
 * You **MUST** use arrays for this Kata. Collections are NOT to be used
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class Riffler {

	/**
	 * Combines the two arrays by alternating the elements from each array
	 * @param source Source array.  Length must be greater than or equal to dest
	 * @param dest Destination array to combine.  Must be within 1 character of
	 * the source length
	 * @return Combined array.  Empty array if invalid data
	 */
	public char[] riffle(char[] source, char[] dest) {
		if(source == null || dest == null) return new char[0];
		if(source.length < dest.length || source.length > dest.length + 1) return new char[0];
		
		int size = source.length + dest.length;
		char[] result = new char[size];
		
		int counter = 0;
		for(int i = 0; i < result.length; i++) {
			result[i] = source[counter];
			i++;
			if(i < result.length) {
				result[i] = dest[counter];
				counter++;
			}
		}
		return result;
	}
	
	/**
	 * Splits the passed array into 2 elements.  
	 * @param combined Array to deriffle
	 * @return Source array as key and the dest array as value
	 */
	public GenericVO deriffle(char[] combined) {
		char[] a = new char[(int) Math.ceil(combined.length * .5)];
		char[] b = new char[(int) Math.floor(combined.length * .5)];
		int counter = 0;
		for(int i = 0; i < combined.length; i++) {
			a[counter] = combined[i];
			i++;
			if(i < combined.length) {
				b[counter] = combined[i];
				counter++;
			}
		}
		return new GenericVO(a, b);
	}
}
