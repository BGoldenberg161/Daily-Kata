package com.smt.kata.math;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
// JDK 11.x
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> PurchaseChange.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Purchase Change
 * 
 * Correctly determine the fewest number of coins/bills to be given to a customer such 
 * that the sum of the coins' value would equal the correct amount of change.
 * 
 * For example
 * 
 * A price of .10 and a .25 paid should return one nickel (5) and one 
 * dime (10) or {DIME=1, NICKEL=1}
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 2, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class PurchaseChange {
	
	/**
	 * Currency enum to track money types
	 */
	public enum Currency {
		TWENTY_DOLLAR, TEN_DOLLAR, FIVE_DOLLAR, DOLLAR, QUARTER, DIME, NICKEL, PENNY;
	}
	
	/**
	 * Calculates the change
	 * @param purchaseAmount The amount of the purchase
	 * @param moneyPaid The amount given to pay for the purchase
	 * @return Map with currencies and amounts
	 */
	public Map<Currency, Integer> calculate(double purchaseAmount, double moneyPaid) {
	
		double change = moneyPaid - purchaseAmount;
		
		if(change <= 0) {
			return new LinkedHashMap<Currency, Integer>();
		}
		
		Map<Currency, Integer> result = new LinkedHashMap<Currency, Integer>();
		result.put(Currency.TWENTY_DOLLAR, 0);
		result.put(Currency.TEN_DOLLAR, 0);
		result.put(Currency.FIVE_DOLLAR, 0);
		result.put(Currency.DOLLAR, 0);
		result.put(Currency.QUARTER, 0);
		result.put(Currency.DIME, 0);
		result.put(Currency.NICKEL, 0);
		result.put(Currency.PENNY, 0);
		
		Map<Double, Currency> coin = new LinkedHashMap<Double, Currency>();
		coin.put(20.00, Currency.TWENTY_DOLLAR);
		coin.put(10.00, Currency.TEN_DOLLAR);
		coin.put(5.00, Currency.FIVE_DOLLAR);
		coin.put(1.00, Currency.DOLLAR);
		coin.put(0.25, Currency.QUARTER);
		coin.put(0.10, Currency.DIME);
		coin.put(0.05, Currency.NICKEL);
		coin.put(0.01, Currency.PENNY);
		
		List<Double> coinValues = new ArrayList<Double>(coin.keySet());
		System.out.println("change: " + change);
		while(change > 0) {
			for (int i = 0; i < coinValues.size(); i++) {
				double currentValue = coinValues.get(i);
				if(change - currentValue >= 0) {
					Currency resultAdd = coin.get(currentValue);
					result.put(resultAdd, result.get(resultAdd) + 1);
					change -= currentValue;
					change = Math.round(change * 100.0) / 100.0;
					System.out.println("new change: " + change);
					break;
				}
			}
		}
		
		return result;
	}
}
