package com.smt.kata.math;

/****************************************************************************
 * <b>Title:</b> NoOpDivision.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> No Operator Division
 * 
 * Implement division of two positive and/or negative integers without using the division, 
 * multiplication, or modulus operators. Return the quotient as an integer, 
 * ignoring the remainder.  The sign of the dividend and divisor must be taken into
 * account.
 * 
 * Example:
 * 
 * 10 / 3 = 3;
 * 
 * 12 / 5 = 2;
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class NoOpDivision {

	/**
	 * Divide two integers and receive an integer.  Round to floor
	 * @param dividend Number to be divided
	 * @param divisor Number to be divided by
	 * @return rounded number.  Zero if dividend or divisor is zero
	 */
	public int divide(int dividend, int divisor) {
		int result = 0;
		boolean trigger = false;
		if(dividend < 0 && divisor > 0) {
			trigger = true;
		}
		if(dividend > 0 && divisor < 0) {
			trigger = true;
		}
		
		System.out.println("dividend: " + dividend);
		System.out.println("divisor: " + divisor);
		for(int i = 0; i < 10; i++) {
			System.out.println("counter: " + result);
			dividend = Math.abs(dividend) - Math.abs(divisor);
			if(dividend >= 0) {
				result++;
			} else {
				System.out.println(result);
				if(trigger) {
					System.out.println("result neg: " + result);
					return 0 - result;	
				} else {
					System.out.println("result: " + result);
					return result;
				}
			}
		}
		return 0;
	}

}
