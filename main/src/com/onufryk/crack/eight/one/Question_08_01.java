/*
 * Write a method to generate the nth Fibonacci number.
pg
 */
package com.onufryk.crack.eight.one;

public class Question_08_01 {
	
	public static Long fibonacci(Long n) {
		if (n == 0) {
			return new Long(1);
		}
		if (n == 1) {
			return new Long(1);
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

	public static void main(String[] args) {
		Integer n = 10;
		System.out.println(Question_08_01.fibonacci(new Long(n)));
	}

}
