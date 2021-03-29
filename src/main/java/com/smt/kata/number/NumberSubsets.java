package com.smt.kata.number;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> NumberSubsets.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Number Subsets
 * Given a multiset of integers, return whether it can be partitioned into two 
 * subsets whose sums are the same.
 * 
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, 
 * it would return true, since we can split it up into {15, 5, 10, 15, 10} and 
 * {20, 35}, which both add up to 55.
 * 
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we 
 * can't split it up into two subsets that add up to the same sum.
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
public class NumberSubsets {
    
    /**
     * Method gets every possible combo and then adds the elements in the combos 
     * to see if we have a match
     * @param elements Elements to use to add the options
     * @return True if there is a matching pattern.  False otherwise
     */
	public boolean findMataches(int[] elements) {
        if(elements == null || elements.length == 0) return false;

        List<Integer> val = new ArrayList<Integer>();
        for(int x = 0; x < elements.length; x++) {
            val.add(elements[x]);
        }
        
        return recurse(val, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public boolean recurse(List<Integer> valuesToUse, int total, List<Integer> additions, List<Integer> subtractions){
        if(valuesToUse.size() == 0){
            return total == 0;
        }
        
        List<Integer> newValues = new ArrayList<>(valuesToUse);
        int nextNumber = newValues.get(newValues.size() - 1);
        newValues.remove(newValues.size() - 1);
        
        List<Integer> changedAdd = new ArrayList<>(additions);
        changedAdd.add(nextNumber);
        
        List<Integer> changedSub = new ArrayList<>(subtractions);
        changedSub.add(nextNumber);

        boolean addition = recurse(newValues, total + nextNumber, changedAdd, subtractions);
        boolean subtraction = recurse(newValues, total - nextNumber, additions, changedSub);

        return addition == true || subtraction == true;
    }
}
