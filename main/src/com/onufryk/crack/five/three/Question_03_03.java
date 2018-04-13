/*
 * Given an integer, print the next smallest and next largest number 
 * that have the same number of 1 bits in their binary representation.
 */
package com.onufryk.crack.five.three;

public class Question_03_03 {

	public static void main(String[] args) {
		int input = 345;
		
		System.out.println(Integer.toBinaryString(input));
		
		
		int numberOfOnes = 0;
		int numberOfZeroes = 0;
		while (input > 0) {
			int r = input % 2;
			if (r == 1) {
				numberOfOnes++;
			} else {
				numberOfZeroes++;
			}
			input = input >> 1;
		}
		
		System.out.println("Number of zeroes: "+ numberOfZeroes);
		System.out.println("Number of ones: " + numberOfOnes);
		
		int smallest = ((1 << numberOfOnes) - 1);
		System.out.println(smallest);
		System.out.println(Integer.toBinaryString(smallest));

		int largest = ((1 << numberOfOnes) - 1) << numberOfZeroes;
		System.out.println(largest);
		System.out.println(Integer.toBinaryString(largest));

	}

}
