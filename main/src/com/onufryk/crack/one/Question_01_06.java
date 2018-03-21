package com.onufryk.crack.one;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Question_01_06 {

	public static void rotate(Integer image[][]) {
		int n = image.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				Integer top = image[first][i];
				image[first][i] = image[last - offset][first];
				image[last - offset][first] = image[last][last - offset];
				image[last][last - offset] = image[i][last];
				image[i][last] = top;
				
			}
		}
	}
	
	public static void print (Integer image[][]) {
		for (int ii = 0; ii < image.length; ii++) {
			for (int jj = 0; jj < image.length; jj++) {
				System.out.print(image[ii][jj]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Integer image[][] = {
				{ 1,  2,  3,  4},
				{ 5,  6,  7,  8},
				{ 9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		print(image);
		rotate(image);
		print(image);
	}

}
