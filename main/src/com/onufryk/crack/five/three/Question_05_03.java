/*
 * Given an integer, print the next smallest and next largest number 
 * that have the same number of 1 bits in their binary representation.
 */
package com.onufryk.crack.five.three;

public class Question_05_03 {
	private static int numberOfOnes(int input) {
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
		return numberOfOnes;
	}
	private static int numberOfZeroes(int input) {
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
		return numberOfZeroes;
	}

	public static void main(String[] args) {
		int input = 345;
		
		System.out.println(Integer.toBinaryString(input));
		
		int numberOfOnes = numberOfOnes(input);
		int numberOfZeroes = numberOfZeroes(input);
		
		System.out.println("Number of zeroes: "+ numberOfZeroes);
		System.out.println("Number of ones: " + numberOfOnes);
		
		int min = ((1 << numberOfOnes) - 1);
		System.out.println("Minimum: " + min + " -> "+Integer.toBinaryString(min));

		int max = ((1 << numberOfOnes) - 1) << numberOfZeroes;
		System.out.println("Maximum: " + max + " -> "+Integer.toBinaryString(max));
		
		int down = input - 1;
		while(numberOfOnes(down) != numberOfOnes && down > 0) {
			down--;
		}
		
		int up = input + 1;
		while(numberOfOnes(down) != numberOfOnes && up < Integer.MAX_VALUE) {
			up++;
		}
		
		System.out.println("Next smallest: " + down + " -> "+Integer.toBinaryString(down));
		
		System.out.println("Next largest: " + up + " -> "+Integer.toBinaryString(up));
		
	}

}
