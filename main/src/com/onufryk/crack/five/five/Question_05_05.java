/*
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * Input: 31, 14
 * Output: 2
 */
package com.onufryk.crack.five.five;

public class Question_05_05 {

	public static void main(String[] args) {
		int a = 31;
		int b = 14;
		Integer diff = a ^ b;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(diff));
		

		int numberOfOnes = 0;
		while (diff > 0) {
			int r = diff % 2;
			if (r == 1) {
				numberOfOnes++;
			}
			diff = diff >> 1;
		}
		
		System.out.println(numberOfOnes);
		
	}

}
