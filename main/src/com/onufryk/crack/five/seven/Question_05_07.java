/*
 * An array A[1... n] contains all the integers from 0 to n except for one number which is missing. 
 * In this problem, we cannot access an entire integer in A with a single operation. 
 * The elements of A are represented in binary, and the only operation we can use to access them is 
 * “fetch the jth bit of A[i]”, which takes constant time. Write code to find the missing integer. 
 * Can you do it in O(n) time?
 */
package com.onufryk.crack.five.seven;

public class Question_05_07 {
	public static int bit(int a, int j) {
		return ((a & (1 << j)) > 0) ? 1 : 0;
	}

	public static void main(String[] args) {
		int numbers[] = {1, 2, 3, 4, 5, 6, 8, 9,10};
		
		int previous = bit(numbers[0], 0);
		
		for (int i = 1; i < numbers.length; i++) {
			if (previous == bit(numbers[i], 0)) {
				System.out.println(numbers[i] - 1);
				break;
			}
			previous = bit(numbers[i], 0);
		}

	}

}
