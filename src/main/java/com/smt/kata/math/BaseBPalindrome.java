package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: BaseBPalindrome.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Base-b Palindromic Numbers
 * 
 * Write a function that finds the positive integers up to 1000 that are palindromes in base 2.
 * 
 * Write a function PalindromicNumbers that takes an integer b that is greater than 1
 * and outputs a list of base–10 numbers less than or equal to 1000 that are palindromic in base b.
 * 
 * More Examples
 * In base 2, the numbers up to 10 that are palindromes are 1, 3, 5:
 * 
 * NOTES - No Collections, Strings, Arrays or most other classes are to be used.  You MAY
 * NOT use the Integer or other number classes to do the base conversions.  Arrays
 * and primitives only.  
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 17, 2021
 * @updates:
 ****************************************************************************/
public class BaseBPalindrome {
	
	/**
	 * 
	 * @param value
	 * @param base
	 * @return
	 */
	 public boolean isPalindrome(int value, int base) {
	        if (value == 0) return true;
	        if (base == 1) return false;
	        if (value < 0) value *=-1;
	        
	        int[] converted = new int[100];
	        int counter = 0;
	        
	        while (value >= base) {
	            converted[counter++] = value % base;
	            value = value / base;
	        }
	        converted[counter] = value;
	        
	        for (int i = 0; i < counter; i++) {
	            if (converted[i] != converted[counter - i]) return false;
	        }
	        
	        return true;
	    }
}
