/*
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it.
 */
package com.onufryk.crack.nine.six;

public class Question_09_06 {

	public static void main(String[] args) {
		int m = 6;
		int n = 5;
		int target = 38;
		int matrix[][] = {
				{ 1,  4,  5,  7,  9, 12},
				{ 2,  8, 16, 17, 20, 33},
				{ 5,  9, 26, 37, 40, 66},
				{ 6, 11, 27, 38, 44, 69},
				{12, 13, 30, 40, 52, 85},
		};
		
		int row = 0;
		int col = m - 1;
		
		while (row < n && col >= 0) {
			if (matrix[row][col] == target) {
				System.out.println(row);
				System.out.println(col);
				break;
			} else if (matrix[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		
	}

}
