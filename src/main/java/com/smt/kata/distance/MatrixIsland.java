package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> MatrixIsland.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Island Matrix
 * 
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. 
 * A 1 represents land and 0 represents water, so an island is a group of 1s that are 
 * neighboring (horizontal or vertical or both.  Diagonal only does not count) whose 
 * perimeter is surrounded by water.  Land (1s) on the outside of the matrix are 
 * considered surrounded by water on those edges.  In other words, the matrix is 
 * surrounded by water. The smallest island has 1 node
 * 
 * For example, the largest island in this matrix is 4
 * 
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 * 
 * Use whatever classes you want for this
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 1, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class MatrixIsland {
    // Members
    protected int[][] matrix;
    protected boolean hasIslands = false;
    protected int numberIslands = 0;
    protected int nodesInLargestIsland = 0;
    protected List<Integer> islands = new ArrayList<>();
    protected int islaSize = 0;
    
    /**
     * Assigns the matrix
     */
    public MatrixIsland(int[][] matrix) throws NullPointerException {
        super();
        this.matrix = matrix;
        countIslands();
        findLargest();
    }
    
    /**
     * Finds the largest island and returns the number of nodes in that island
     * @return Number of nodes in the largest island
     */
    protected void findLargest() {
        if (islands.isEmpty()) nodesInLargestIsland = 0;
        else nodesInLargestIsland = Collections.max(islands);
    }
    
    /**
     * Calculates if there are any islands and how many.  Updates the member 
     * variables when complete
     */
    protected void countIslands() {
        if (matrix == null || matrix.length <= 0) throw new NullPointerException();
        for (int y=0; y< matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 1) {
                    hasIslands = true;
                    checkArround(y, x);
                    islands.add(islaSize);
                    islaSize = 0;
                }
            }
        }
        
        numberIslands = islands.size();
    }
    public void checkArround(int y, int x) {
        if (matrix[y][x] == 1) {
            islaSize++;
            matrix[y][x] = 0;
            
            //check below
            if (matrix.length > y+1) {
                checkArround(y+1, x);
            }
                
            // check above
            if (y-1 >= 0) {
                checkArround(y-1, x);
            }
                
            // check right
            if (matrix[0].length > x+1) {
                checkArround(y, x+1);
            }
            // check left
            if (x-1 >= 0) {
                checkArround(y, x-1);
            }    
        }
    }

    /**
     * @return the hasIslands
     */
    public boolean hasIslands() {
        return hasIslands;
    }

    /**
     * @return the numberIslands
     */
    public int getNumberIslands() {
        return numberIslands;
    }

    /**
     * @return the nodesInLargestIsland
     */
    public int getNodesInLargestIsland() {
        return nodesInLargestIsland;
    }

}