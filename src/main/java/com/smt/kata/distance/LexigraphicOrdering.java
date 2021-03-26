package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> LexigraphicOrdering.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Lexigraphic Ordering
 * 
 * You are given an N by M 2D matrix of lowercase letters. Determine the minimum 
 * number of columns that can be removed to ensure that each row is ordered from 
 * top to bottom lexicographically. That is, the letter at each column is 
 * lexicographically later as you go down each row. It does not matter whether 
 * each row itself is ordered lexicographically.
 * 
 * For example, given the following table:
 * 
 * cba
 * daf
 * ghi
 * 
 * This is not ordered because of the a in the center. We can remove the second 
 * column to make it ordered:
 * 
 * ca
 * df
 * gi
 * 
 * So your function should return the above updated Matrix, since we only needed to remove 1 column.
 * As another example, given the following table:
 * 
 * abcdef
 * 
 * Your function should return the original, since the rows are already ordered (there's only one row).
 * As another example, given the following table:
 * 
 * zyx
 * wvu
 * tsr
 * 
 * Your function should return an empty matrix, since we would need to remove all the columns to order it.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class LexigraphicOrdering {

	/**
	 * Reorders the columns based upon lexigraphic order
	 * @param data matrix data to process
	 * @return matrix of data that is properly ordered
	 */
	public char[][] orderData(char[][] data) {
		if(data == null || data.length == 0) {
			return new char[0][0];
		}
		
		if(data.length == 1) return data;
		List<Integer> remove = new ArrayList<>(); 
		
		for(int i = 0; i < data[0].length; i++) {
			int charVal = 0;
			for(int j = 0; j < data.length; j++) {
				char d = data[j][i];
				int currentVal = Integer.valueOf(data[j][i]);
				if (currentVal < charVal) {
					remove.add(i);
					break;
				}else {
					charVal = currentVal;
				}
			}
		}
		System.out.println(remove.size());
		char[][] result;
		if(data.length == remove.size()) {
			result = new char[0][0];
		}else {
			result = new char[data.length][data[0].length - remove.size()];
		}
		
		if(remove.size() == 0) return data;
		
		for(int k = 0; k < data.length; k++) {
			int column = 0;
			for(int x = 0; x < data[0].length; x++) {
				boolean contains = false;
				for(int y = 0; y < remove.size(); y++) {
					if (remove.get(y).equals(x)) {
						System.out.println("contains");
						contains = true;
					}
				}
				if(contains) {
					
				}else {
					result[k][column] = data[k][x];
					column++;
				}
			}
			
		}
		return result;
	}
}
