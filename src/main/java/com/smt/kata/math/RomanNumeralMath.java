package com.smt.kata.math;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: RomanNumeralMath.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Roman Numeral Math
 * Take 2 roman numerals and return the sum or difference between the 2 values.
 * When subtracting, use absolute value for the difference to ensure the number
 * returned is always positive
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
public class RomanNumeralMath {
    
    /**
     * Takes two roman numerals and adds them together
     * @param first
     * @param second
     * @return
     */
    public String add(String first /*III*/, String second /*I*/) {
        System.out.println("start");
    	if(StringUtils.isEmpty(first) || first.contains("0") || StringUtils.isEmpty(second) || second.contains("0")) {
			return "";
		}
        
        int total = getIntegerValue(first) + getIntegerValue(second);
        System.out.println("total");
        System.out.println(total);
        System.out.println(getRomanNumeral(total));
        return getRomanNumeral(total);
    }

    /**
     * Takes two roman numerals and subtracts them.  Absolute value is
     * used to ensure a positive number
     * @param first
     * @param second
     * @return
     */
    public String subtract(String first, String second) {
        
    	if(StringUtils.isEmpty(first) || first.contains("0") || StringUtils.isEmpty(second) || second.contains("0")) {
			return "";
		}
        
        int total = getIntegerValue(first) - getIntegerValue(second);    
        
        return getRomanNumeral(Math.abs(total));
    }

    private static Map<Integer, String> numerals = new LinkedHashMap<Integer,String>() {
        private static final long serialVersionUID = 1L; {
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }
    };
    /**
     * Convert a number into its roman numeral counterpart
     * @param startNumber
     * @return
     */
    public String getRomanNumeral(int number){
		StringBuilder roman = new StringBuilder();
		List<Integer> numeralKeys = new ArrayList<>(numerals.keySet());
		
		// Loop the map of numeral
		for (int i = 0; i < numeralKeys.size(); i++) {
			int val = numeralKeys.get(i);
			int numVal = number/val;
			
			// Loop the number of elements for the given numerals value.
			if (numVal > 0) {
				for(int x = 0; x < numVal; x++) {
					roman.append(numerals.get(val));
				}
				
				number -= (val * numVal);
			} 

			// Check to see if we need to subtract 1 from the next version (IX for 9)
			if (number > 0 && (number + 1) == val) {
				int item = (i + 2) > 6 ? 6 : i + 2;
				roman.append(numerals.get(numeralKeys.get(item)));
				roman.append(numerals.get(val));
				
				number -= (val - numeralKeys.get(item));
			}
		}
		
		return roman.toString();
	}
    
    private static Map<String, Integer> integers = new LinkedHashMap<String,Integer>() {
        private static final long serialVersionUID = 1L; {
            put("M", 1000);
            put("D", 500);
            put("C", 100);
            put("L", 50);
            put("X", 10);
            put("V", 5);
            put("I", 1);
        }
    };
    
    public static int getIntegerValue(String roman) { 
        
    	System.out.println(roman);
    	
        int result = 0;
        int prev = 0;
        
        for(int i = roman.length() - 1; i >= 0; i--) {
        	
           int temp = integers.get(Character.toString(roman.charAt(i)));
           
	       if(temp < prev) {
	           result -= temp;
	       } else {
	    	   result += temp;                    
	       }
	       
	       prev = temp;
        }
        
        System.out.println(result);
        return result;
    }   
    
}