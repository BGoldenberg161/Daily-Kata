package com.smt.kata.distance;

import java.util.Iterator;

import jakarta.validation.constraints.Null;

/****************************************************************************
 * <b>Title:</b> QueenAttack.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Queen Attack Kata
 * 
 * Given the position of two queens on a chess board, indicate whether or not 
 * they are positioned so that they can attack each other. In the game of chess, 
 * a queen can attack pieces which are on the same row, column, or diagonal.  A 
 * chess board can be represented by an 8 by 8 array.  You must initialize the board to 
 * have the '-' character to simulate the board as shown below.
 * 
 * So if you're told the white queen is at (2, 3) and the black queen at (5, 6), 
 * then you'd know you've got a set-up like so:
 * 
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ _ _
 * _ _ _ W _ _ _ _
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ B _
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ _ _
 * 
 * You'd also be able to answer whether the queens can attack each other. In 
 * this case, that answer would be yes, they can, because both pieces share a diagonal.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class QueenAttack {
	
	// Members
	protected char[][] chessboard;

	/**
	 * Initialize the chess board
	 * @param chessboard 2d array that expresses the chess board
	 */
	public QueenAttack(char[][] chessboard) {
		super();
		
		for(int i=0;i<=7;i++){
			for(int j=0;j<=7;j++){
				chessboard[i][j]='-';
			}
		}
		this.chessboard = chessboard;
	}
	
	/**
	 * Determines if the black and white queen can attach each other in any direction
	 * @param white coordinate for the white queen
	 * @param black coordinate for the black queen
	 * @return true if they can attack in any direction.  False otherwise
	 */
	public boolean canAttack(int[] white, int[] black) {
		// check length & null case\
		if (white == null || black == null) return false;
		if (white.length != 2 || black.length != 2 ) return false;
			
		int white_row = white[0];
		int black_row=black[0];
		
		if(checkHorizontal(white_row, black_row)){
			return true;
		}
		
		int white_col = white[1];
		int black_col=black[1];
		
		if(checkVertical(white_col, black_col)){
			return true;
		}
		
		if(checkDiag(white, black)){
			return true;
		}
		
		return false;
	}
	
	public boolean checkHorizontal(int a, int b){
		return a == b;
	}
	
	public boolean checkVertical(int a, int b){
		return a == b;
	}
	
	//a == smaller values
	public boolean checkDiag(int[] a, int[] b){
		//move a up & left
		int[] tempA = new int[] {a[0], a[1]};
		while(tempA[0] >= 0 && tempA[1] >= 0){
			if(tempA[0] == b[0] && tempA[1] == b[1]) return true;
			tempA[0]--;
			tempA[1]--;
		}
		
		//move a up & right
		int[] tempB = new int[] {a[0], a[1]};
		while(tempB[0] >= 0 && tempB[1] <= 7){
			if(tempB[0] == b[0] && tempB[1] == b[1]) return true;
			tempB[0]--;
			tempB[1]++;
		}
		
		//move a down & right
		int[] tempC = new int[] {a[0], a[1]};
		while(tempC[0] <= 7 && tempC[1] <= 7){
			if(tempC[0] == b[0] && tempC[1] == b[1]) return true;
			tempC[0]++;
			tempC[1]++;
		}
		
		//move a down & left
		int[] tempD = new int[] {a[0], a[1]};
		while(tempD[0] <= 7 && tempD[1] >= 0){
			if(tempD[0] == b[0] && tempD[1] == b[1]) return true;
			tempD[0]++;
			tempD[1]--;
		}
		
		return false;
	}
}
