package com.onufryk.crack;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0.
 */
public class Question_01_07 {
	
	public static void print (Integer image[][]) {
		for (int ii = 0; ii < image.length; ii++) {
			for (int jj = 0; jj < image.length; jj++) {
				System.out.print(image[ii][jj]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void zero(Integer image[][]) {
		boolean zeroRows[] = new boolean[image.length];
		boolean zeroCols[] = new boolean[image.length];
		
		for (int ii = 0; ii < image.length; ii++) {
			for (int jj = 0; jj < image.length; jj++) {
				if (image[ii][jj] == 0) {
					zeroRows[ii] = true;
					zeroCols[jj] = true;
				}
			}
		}
		for (int ii = 0; ii < image.length; ii++) {
			for (int jj = 0; jj < image.length; jj++) {
				if(zeroRows[ii] || zeroCols[jj]) {
					image[ii][jj] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer image[][] = {
				{ 1,  2,  3,  4},
				{ 5,  0,  7,  8},
				{ 9, 10, 0, 12},
				{13, 14, 15, 16}
		};
		print(image);
		zero(image);
		print(image);
	}

}
