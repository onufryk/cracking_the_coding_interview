/*
 * Write an algorithm to print all ways of arranging eight queens on a chess board 
 * so that none of them share the same row, column or diagonal.
 */
package com.onufryk.crack.eight.eight;

public class Question_08_08 {
	static int columnForRow[] = new int[8];

	public static void printBoard() {
		for (int ii = 0; ii < 8; ii++) {
			System.out.println(columnForRow[ii]);
		}
	}

	public static boolean check(int row) {
		for (int i = 0; i < row; i++) {
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (diff == 0 || diff == row - i)
				return false;
		}
		return true;
	}

	public static void PlaceQueen(int row) {
		if (row == 8) {
			printBoard();
			return;
		}
		for (int i = 0; i < 8; i++) {
			columnForRow[row] = i;
			if (check(row)) {
				PlaceQueen(row + 1);
			}
		}
	}

	public static void main(String[] args) {
		PlaceQueen(0);
	}

}
