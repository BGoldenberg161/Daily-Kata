package com.smt.kata.code;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: CreditCardValidator.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Validate Credit Card Number
 * Create a function that takes a number as an argument and returns true if the number 
 * is a valid credit card number, false otherwise.
 * 
 * Credit card numbers must be between 14-19 digits in length, and pass the
 *  Luhn test, described below:
 * 
 * Remove the last digit (this is the "check digit").
 * Reverse the number.
 * Double the value of each digit in odd-numbered positions. If the doubled 
 * value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
 * Add all digits.
 * Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
 * 
 * Examples
 * validateCard(1234567890123456) ➞ false
 * 
 * // Step 1: check digit = 6, num = 123456789012345
 * // Step 2: num reversed = 543210987654321
 * // Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
 * // Step 4: sum = 58
 * // Step 5: 10 - 8 = 2 (not equal to 6) ➞ false
 * 
 * isValid(1234567890123452) ➞ true
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class CreditCardValidator {
	
	/**
	 * Validates the provided CC number
	 * @param ccn
	 * @return
	 */
	public boolean isValid(String ccn) {
		
		if(StringUtils.isEmpty(ccn) || ccn.matches(".*[a-zA-Z]+.*") || ccn.contains(" ")) {
			return false;
		}
		
		System.out.println(ccn);
		String checkDigit = ccn.substring(ccn.length() - 1);
		String noLast = (ccn.substring(0, ccn.length() - 1));
		String reversed = new StringBuffer(noLast).reverse().toString();
		System.out.println(reversed);
		
		String[] revArr = reversed.split("");
		int sum = 0;
		
		for(int i = 0; i < revArr.length; i++) {
			if(i%2 == 0) {
				int temp = Integer.parseInt(revArr[i]) * 2;
				if(String.valueOf(temp).length() > 1) {
					int firstDigit = Integer.parseInt(Integer.toString(temp).substring(0, 1));
					int secondDigit = Integer.parseInt(Integer.toString(temp).substring(1, 2));
					temp = firstDigit + secondDigit;
				}
				revArr[i] = String.valueOf(temp);
			}
			sum += Integer.parseInt(revArr[i]);
		}
		
		String sumString = String.valueOf(sum);
		String newLast = sumString.substring(sumString.length() - 1);
		
		
		return (10 - Integer.parseInt(newLast) == Integer.parseInt(checkDigit));
	}
}
