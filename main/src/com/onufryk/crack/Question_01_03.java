package com.onufryk.crack;

/*
 * Design an algorithm and write code to remove the duplicate characters in a string 
 * without using any additional buffer. NOTE: One or two additional variables are fine. 
 * An extra copy of the array is not.
 */
public class Question_01_03 {

	public static void dedupe(char[] original) {
		if (original == null) {
			return;
		}
		int len = original.length;
		if (len < 2) {
			return;
		}
		
		int tail = 1;
		for (int ii = 1; ii < len; ++ii) {
			int jj;
			for (jj = 0; jj < tail; ++jj) {
				if (original[ii] == original[jj]) {
					break;
				}
				if (jj == tail) {
					original[tail] = original[ii];
					++tail;
				}
			}
		}
		original[tail] = 0;
	}

	public static void main(String[] args) {
		char str[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		dedupe(str);
		for (int ii = 0; ii < str.length; ii++) {
			System.out.print(str[ii]);
		}
		System.out.println();
	}

}
