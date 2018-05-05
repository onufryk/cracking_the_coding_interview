/*
 * Implement the “paint fill” function that one might see on many image editing programs. 
 * That is, given a screen (represented by a 2-dimensional array of Colors), a point, and a new color, 
 * fill in the surrounding area until you hit a border of that color.
 */
package com.onufryk.crack.eight.six;


public class Question_08_06 {

	public static void fill(Integer[][] image, Integer x, Integer y, Integer color) {
		if (x < 0 || x == 12) {
			return;
		}
		if (y < 0 || y == 12) {
			return;
		}
		if (image[x][y] == color) {
			return;
		}
		image[x][y] = color;
		fill(image, x - 1, y, color);
		fill(image, x + 1, y, color);
		fill(image, x, y - 1, color);
		fill(image, x, y + 1, color);
	}

	public static void main(String[] args) {
		Integer[][] image = new Integer[][] {
			{0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
		};
		
		fill(image, 5, 6, 1);
		
		for (int ii = 0; ii < image.length; ii++) {
			for (int jj = 0; jj < image.length; jj++) {
				System.out.print(image[ii][jj] > 0 ? image[ii][jj] : " ");
			}
			System.out.println();
		}

	}

}
