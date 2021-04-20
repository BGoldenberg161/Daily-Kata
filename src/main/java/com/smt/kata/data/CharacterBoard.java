package com.smt.kata.data;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> CharacterBoard.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Character Board
 * 
 * Given a 2D board of characters and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may be used more than once.
 * For example, given the following board:
 * 
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 
 * exists(board, "ABCCED") returns true, 
 * exists(board, "SEE") returns true, 
 * exists(board, "ABCB") returns true.
 * exists(board, "ACE") returns false.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 15, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class CharacterBoard {
    
    protected char[][] board;
    
    /**
     * Initializes the class with a 2d matrix
     * @param board matrix of characters
     */
    public CharacterBoard(char[][] board) {
        this.board = board;
    }

    /**
     * Runs through the character board and finds the provided word
     * @param word Word to search the board
     * @return True if word is in the board, false otherwise
     */
    public boolean exists(String word) {
        if(word == null || word.length() == 0)
            return false;
        
        word = word.toUpperCase();
        char first = word.charAt(0);
        
        /** Loop to find good entry point **/
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == first && pathfind(word.substring(1), row, col)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean pathfind(String word, int row, int col) {
        if(word.length() == 0) return true;
        List<CharIndex> nextChars = getNextChars(row,col);
        
        /** Loop over next characters **/
        for(CharIndex c : nextChars) {
            if(c.character == word.charAt(0) && pathfind(word.substring(1), c.row, c.col)) {
                return true;
            }
        }
        return false;
    }
    
    public List<CharIndex> getNextChars(int row, int col) {
        List<CharIndex> result = new ArrayList<>();
        //top
        if (row > 0)
            result.add(new CharIndex(this.board[row - 1][col], row - 1, col));
        // left
        if (col > 0)
            result.add(new CharIndex(this.board[row][col - 1], row, col - 1));    
        // bottom
        if (row < board.length - 1)
            result.add(new CharIndex(this.board[row + 1][col], row + 1, col));
        // right
        if (col < board[0].length - 1)
            result.add(new CharIndex(this.board[row][col + 1], row, col + 1));
        
        return result;
    }
}

class CharIndex {
    public char character;
    public int row;
    public int col;
    
    public CharIndex(char character, int row, int col) {
        this.character = character;
        this.row = row;
        this.col = col;
    }
}