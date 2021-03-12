package com.smt.kata.distance;

import org.apache.commons.lang3.StringUtils;

// JDK 11.x

/****************************************************************************
 * <b>Title</b>: WordMatrix.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Word Matrix
 * Given a 2D matrix of characters and a target word, write a function that returns 
 * whether the word can be found in the matrix by going left-to-right, right to Left, 
 * up-to-down or down to up.
 * 
 * For example, given the following matrix:
 *
 *	{
 *		{ 'F', 'A', 'C', 'I', 'H', 'E', 'L', 'L', 'O', '!' },
 *		{ 'O', 'B', 'Q', 'P', 'I', 'L', 'R', 'K', 'I', 'M' },
 *		{ 'A', 'N', 'O', 'B', 'J', 'B', 'D', 'L', 'I', 'E' },
 *		{ 'M', 'A', 'S', 'S', 'U', 'I', 'F', 'O', 'O', 'A' },
 *		{ 'K', 'V', 'W', 'Q', 'S', 'B', 'F', 'O', 'V', 'B' },
 *		{ 'O', 'L', 'A', 'X', 'P', 'E', 'K', 'T', 'A', 'E' },
 *		{ 'N', 'D', 'V', 'F', 'I', 'E', 'S', 'P', 'M', 'T' },
 *		{ 'R', 'D', 'P', 'L', 'N', 'R', 'X', 'Q', 'B', 'J' },
 *		{ 'P', 'U', 'L', 'L', 'G', 'U', 'Q', 'W', 'D', 'I' },
 *		{ 'Z', 'M', 'B', 'B', 'H', 'I', 'A', 'I', 'Z', 'M' }
 *	}
 * 
 * and the target word 'FOAM', you should return true, since it's in the left most 
 * column. Similarly, given the target word 'MASS', you should return true, 
 * since it's in the fourth row.
 * 
 * Bonus activities:
 * Find words that are diagonally oriented in both directions as well (the word BOSSES goes diagonal 
 * from position 1,2)

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
public class WordMatrix {
	
	// Members
	protected char[][] matrix = new char[][] {
		{ 'F', 'A', 'C', 'I', 'H', 'E', 'L', 'L', 'O', '!' },
		{ 'O', 'B', 'Q', 'P', 'I', 'L', 'R', 'K', 'I', 'M' },
		{ 'A', 'N', 'O', 'B', 'J', 'B', 'D', 'L', 'I', 'E' },
		{ 'M', 'A', 'S', 'S', 'U', 'I', 'F', 'O', 'O', 'A' },
		{ 'K', 'V', 'W', 'Q', 'S', 'B', 'F', 'O', 'V', 'B' },
		{ 'O', 'L', 'A', 'X', 'P', 'E', 'K', 'T', 'A', 'E' },
		{ 'N', 'D', 'V', 'F', 'I', 'E', 'S', 'P', 'M', 'T' },
		{ 'R', 'D', 'P', 'L', 'N', 'R', 'X', 'Q', 'B', 'J' },
		{ 'P', 'U', 'L', 'L', 'G', 'U', 'Q', 'W', 'D', 'I' },
		{ 'Z', 'M', 'B', 'B', 'H', 'I', 'A', 'I', 'Z', 'M' }
	};

	/**
	 * Determines if the provided phrase is in the matrix
	 * either horizontally or vertically
	 * @return
	 */
	public boolean contains(String phrase) {
		// check empty
		if(StringUtils.isEmpty(phrase)) {
			return false;
		}
		
		// check rows
		// columns
		for(int i = 0; i < matrix[0].length; i++) {
			String result = "";
			// rows
			for(int j = 0; j < matrix.length; j++) {
				result += matrix[i][j];
			}
			String rev = new StringBuffer(result).reverse().toString();
			if (result.toLowerCase().contains(phrase.toLowerCase()) || rev.toLowerCase().contains(phrase.toLowerCase())) {
				return true;
			}
		}
		
		// check columns
		// rows
		for(int i = 0; i < matrix.length; i++) {
			String result = "";
			// columns
			for(int j = 0; j < matrix[0].length; j++) {
				result += matrix[j][i];
			}
			String rev = new StringBuffer(result).reverse().toString();
			if (result.toLowerCase().contains(phrase.toLowerCase()) || rev.toLowerCase().contains(phrase.toLowerCase())) {
				return true;
			}
		}
		
		// check diagonal
		// top left -->
		// rows
		int count = 0;
		String result = "";
		for(int i = 0; i < matrix.length; i++) {
			result += matrix[i][count];
			count++;
		}
		System.out.println(result);
		String rev = new StringBuffer(result).reverse().toString();
		if (result.toLowerCase().contains(phrase.toLowerCase()) || rev.toLowerCase().contains(phrase.toLowerCase())) {
			return true;
		}
		return false;
	}
}
