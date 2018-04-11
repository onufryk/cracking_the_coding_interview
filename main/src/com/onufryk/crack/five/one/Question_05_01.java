/*
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * Write a method to set all bits between i and j in N equal to M 
 * (e.g., M becomes a substring of N located at i and starting at j).
 * 
 * EXAMPLE:
 * Input:  N = 10000000000, M = 10101, i = 2, j = 6
 * Output: N = 10001010100
 */
package com.onufryk.crack.five.one;

public class Question_05_01 {

	public static void main(String[] args) {
		long n = 0b10000111000;
		long m = 0b10101;
		int i = 2;
		int j = 6;
		
		long max = ~0;
		long left = max - ((1 << j) - 1);
		long right = ((1 << i) - 1);
		long mask = left | right;
		
		System.out.println(Long.toBinaryString((n & mask) | (m << i)));
	}

}
