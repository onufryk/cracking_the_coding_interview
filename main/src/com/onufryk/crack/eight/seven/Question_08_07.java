/*
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
 * write code to calculate the number of ways of representing n cents.
 */
package com.onufryk.crack.eight.seven;

public class Question_08_07 {
	public static void represent(Integer n) {
		System.out.println(represent(n, 0));
	}
	public static Integer represent(Integer n, Integer counter) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		return counter + represent(n - 1, counter)  + represent(n - 5, counter) + represent(n - 10, counter) + represent(n - 25, counter);
	}

	public static void main(String[] args) {
		represent(10);
	}

}
