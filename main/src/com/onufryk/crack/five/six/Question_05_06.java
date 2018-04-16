/*
 * Write a program to swap odd and even bits in an integer with as few instructions as possible 
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
 */
package com.onufryk.crack.five.six;

public class Question_05_06 {

	public static void main(String[] args) {
		int a = 0b10011100; // 01101100
		int maskOdd = 0b10101010;
		int maskEven = 0b01010101;
		
		System.out.println(Integer.toBinaryString(((a & maskOdd) >> 1) | ((a & maskEven) << 1)));
		

	}

}
