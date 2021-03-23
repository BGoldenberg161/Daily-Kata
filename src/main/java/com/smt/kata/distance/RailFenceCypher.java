package com.smt.kata.distance;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title:</b> RailFenceCypher.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Rail Fence Cypher
 * Implement encoding and decoding for the rail fence cipher.
 * 
 * The Rail Fence cipher is a form of transposition cipher that gets its name from 
 * the way in which it's encoded. It was already used by the ancient Greeks.
 * 
 * In the Rail Fence cipher, the message is written downwards on successive "rails" 
 * of an imaginary fence, then moving up when we get to the bottom (like a zig-zag). 
 * Finally the message is then read off in rows.
 * 
 * For example, using three "rails" and the message "WE ARE DISCOVERED FLEE AT ONCE", 
 * the cipherer writes out:
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . A . . . I . . . V . . . D . . . E . . . N . .
 * Then reads off:
 * 
 * WECRLTEERDSOEEFEAOCAIVDEN
 * To decrypt a message you take the zig-zag shape and fill the ciphertext along the rows.
 * 
 * ? . . . ? . . . ? . . . ? . . . ? . . . ? . . . ?
 * . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * The first row has seven spots that can be filled with "WECRLTE".
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * Now the 2nd row takes "ERDSOEEFEAOC".
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * Leaving "AIVDEN" for the last row.
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . A . . . I . . . V . . . D . . . E . . . N . .
 * 
 * If you now read along the zig-zag shape you can read the original message.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class RailFenceCypher {
	
	/**
	 * 
	 */
	public RailFenceCypher() {
		super();
	}

	/**
	 * Loops the phrase and performs a Rail Fence Cypher
	 * @param phrase Phrase to be encoded 
	 * @return Rail Fence Cypher encoded phrase
	 */
	public String encodePhrase(String phrase) {
		if (StringUtils.isEmpty((phrase))){
            return "";
        }
		String newPhrase = phrase.replace(" ", "").toUpperCase().trim();
		String[] letters = newPhrase.split("");
		
		String result = "";
		//first iteration(skip 3)(start @ 0)
		for(int i = 0; i < letters.length; i += 4) {
			result += letters[i];
		}
		//second iteration(skip 1)(start @ 1)
		for(int i = 1; i < letters.length; i += 2) {
			result += letters[i];
		}
		//third iteration(skip 3)(start @ 2)
		for(int i = 2; i < letters.length; i += 4) {
			result += letters[i];
		}
		
		return result;
	}
	
	/**
	 * Returns the matrix of the phrase
	 * @param phrase Phrase ot encode into the matrix
	 * @return Matrix of the cypher
	 */
	public char[][] getMatrixFromPhrase(String phrase) {
		if (StringUtils.isEmpty((phrase))){
            return "";
        }
		String newPhrase = phrase.replace(" ", "").toUpperCase().trim();
		String[] letters = newPhrase.split("");
		
		int skip = 3;
		int timesSkipped = 0;
		
		String[][] matrix = new String[2][25];
		
		int r = 0;
		int c = 0;
		
		for (int i = 0; i < letters.length; i++) {
			matrix[r][c] = letters[i];
			if(timesSkipped >= 1) {
				for(int j = 0; j < skip; j++) {
					c++;
					matrix[r][c] = ".";
				}
				timesSkipped += 1;
			}
		}
		return new char[0][];
	}

}
