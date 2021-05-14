package com.smt.kata.time;

// JDK 11.x
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: MostOccurringWeekday.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Most-Occurring Weekdays in a Year
 * 
 * Find the weekdays that occur the most in a given year.
 * 
 * Write a function MostOccurringWeekday that takes an integer representing a 
 * year as input and returns a list of the most-occurring weekdays throughout that year.
 * 
 * =MostOccurringWeekday[2018]
 * {Monday}
 * 
 * MostOccurringWeekday[2009]
 * {Thursday}
 * 
 * Multiple weekdays occurred the most in 2012:
 * 
 * MostOccurringWeekday[2012]
 * {Sunday, Monday}
 * 
 * ******** Note: Be careful.  Dates may be negative (IE, BC dates)
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 10, 2021
 * @updates:
 ****************************************************************************/
public class MostOccurringWeekday {
	/**
	 * Enum for the day of the week
	 */
	public enum WeekDay {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	/**
	 * Calculates the most occurring week day for the given year 
	 * @param year Year to calculate against
	 * @return Collection of weekdays
	 */
	public List<WeekDay> calculate(int year) {
		if(year == 0) return new ArrayList<>();
		
		Map<Integer, WeekDay> days = new LinkedHashMap<>();
		days.put(1, WeekDay.SUNDAY);
		days.put(2, WeekDay.MONDAY);
		days.put(3, WeekDay.TUESDAY);
		days.put(4, WeekDay.WEDNESDAY);
		days.put(5, WeekDay.THURSDAY);
		days.put(6, WeekDay.FRIDAY);
		days.put(7, WeekDay.SATURDAY);
		
		List<WeekDay> result = new ArrayList<>();
		
		// get first day
		Calendar cal = Calendar.getInstance();
		cal.set(year, 0, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("first: " + firstDay);
		
		//add day to results
		result.add(days.get(firstDay));
		
		//get last day
		cal.set(year, 11, 31);
		int lastDay = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("last: " + lastDay);
		//if last day != first day, add to results
		if(firstDay != lastDay) {
			result.add(days.get(lastDay));
		}
		
		// Return the collection of most occurring
		return result;
	}

}
