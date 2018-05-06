/*
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
package com.onufryk.crack.nine.one;

public class Question_09_01 {
	public static void println(Integer[] arr, Integer mark) {
		for (int ii = 0; ii < arr.length; ii++) {
			if (arr[ii] == null) {
				break;
			}
			System.out.print(ii == 0 ? "" : ", ");
			System.out.print(arr[ii]);
			if (mark != null && mark == ii) {
				System.out.print(".");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer an = 10;
		Integer bn = 10;
		Integer[] a = new Integer[an + bn];
		Integer[] b = new Integer[bn];

		a[0] = 3;
		a[1] = 4;
		a[2] = 5;
		a[3] = 8;
		a[4] = 9;
		a[5] = 13;
		a[6] = 15;
		a[7] = 16;
		a[8] = 20;
		a[9] = 21;

		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		b[3] = 7;
		b[4] = 11;
		b[5] = 12;
		b[6] = 13;
		b[7] = 14;
		b[8] = 22;
		b[9] = 23;
		
		println(a, null);
		println(b, null);

		int i = 0;
		int j = 0;

		while (i < an + bn && j < bn) {
			while ((a[i] == null || a[i] <= b[j]) && i < an + bn) {
				i++;
				if (a[i] == null) {
					break;
				}
			}
			int count = 0;
			while ((a[i] == null || a[i] >= b[j]) && j < bn) {
				j++;
				count++;
			}

			for (int k = a.length - 1; k >= i; k--) {
				if (a[k] == null) {
					continue;
				}
				a[k + count] = a[k];
				a[k] = 0;
			}

			for (int k = 0; k < count; k++) {
				a[k + i] = b[j - count + k];
			}
			i = i + count;

			println(a, i);
			println(b, j);
			
		}

	}

}
