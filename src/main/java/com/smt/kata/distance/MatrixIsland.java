package com.smt.kata.distance;

import java.util.Arrays;

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
    protected int numberIslands = 0;
    protected int nodesInLargestIsland = 0;
    
    /**
     * Assigns the matrix
     */
    public MatrixIsland(int[][] matrix) throws NullPointerException {
        super();
        this.matrix = matrix;
        if(matrix == null || matrix.length == 0) {
            throw new NullPointerException();
        }
        countIslands();
    }
    
    /**
     * Calculates if there are any islands and how many.  Updates the member 
     * variables when complete
     */
    protected void countIslands() {
        for(int i = 0; i < matrix.length; i++) 
            for(int j = 0; j < matrix[i].length; j++) 
                if(matrix[i][j] == 1) {
                    numberIslands++;
                    nodesInLargestIsland = Math.max(nodesInLargestIsland, exploreIslandFast(i,j,0));
                }        
    }

    /**
     * @param x
     * @param y
     * @param total
     * @return
     */
    protected int exploreIslandFast(int x, int y, int total){
        return ((x >= 0 && y >= 0 && x <= this.matrix.length - 1 && y <= this.matrix[x].length - 1) && matrix[x][y] == 1 && ((matrix[x][y] = 2) == 2)) ? total = Arrays.asList(exploreIslandFast(x - 1, y,total), exploreIslandFast(x + 1, y,total), exploreIslandFast(x, y + 1, total), exploreIslandFast(x, y - 1, total), 1).stream().reduce(0, (a, b) -> a + b) : 0;
    }

    /**
     * @return the hasIslands
     */
    public boolean hasIslands() {
        return numberIslands > 0;
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