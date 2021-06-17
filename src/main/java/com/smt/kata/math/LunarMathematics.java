package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: LunarMathematics.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Lunar Mathematics 
 * 
 * Lunar Mathematics, otherwise known as 'Dismal Mathematics'
 * (a play on 'decimal mathematics'), was created as an alternate way to view
 * mathematics interacts with numbers. Here, we will create the addition
 * function.
 * 
 * On the moon, there is no need to carry over numbers into the next column.
 * Instead, we take the largest value of each column, and set that as our total.
 * 
 * Examples:
 * 
 * 8 + 7 ---- 8 <- Since 8 is the larger number of the two, it is the one used.
 * 
 * 234 + 180 ----- 284 <- the larger values of each number are used for each portion.
 * 
 * 50 +59 ------ 59 <- If a number in two columns match, either one of the
 * numbers can be used.
 * 
 * 465 + 72 ----- 475 <- You must handle situations where numbers are not of
 * equal length Assume all numbers given are valid, nonnegative integers (as
 * there are no negative numbers on the moon). 
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class LunarMathematics {
	
	/**
	 * Performs Lunar Math on the 2 provided numbers
	 * @param firstNumber First number to add
	 * @param secondNumber Second Number to add
	 * @return Total of the lunar math addition of the provided 2 numbers
	 */
	public int add(int firstNumber, int secondNumber) {
        String first = Math.abs(firstNumber) + "";
        String second = Math.abs(secondNumber) + "";
        String output = "";
        
        int index = 0;
        while(index < first.length() || index < second.length()){
            int m1 = 0, m2 = 0;
            if(index < first.length())
                m1 = Integer.parseInt(first.charAt(first.length() - 1 - index) + "");
            if(index < second.length())
                m2 = Integer.parseInt(second.charAt(second.length() - 1 - index) + "");
            output = Math.max(m1,m2) + output;
            index++;
        }
        return Integer.parseInt(output);
    }

}
