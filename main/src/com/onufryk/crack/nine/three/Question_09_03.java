/*
 * Given a sorted array of n integers that has been rotated an unknown number of times, 
 * give an O(log n) algorithm that finds an element in the array. 
 * You may assume that the array was originally sorted in increasing order.
 * 
 * EXAMPLE:
 * 	Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 * 	Output: 8 (the index of 5 in the array)
 */
package com.onufryk.crack.nine.three;

public class Question_09_03 {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 14, 15, 16, 19, 20, 25, 1, 3, 4, 5, 7};
		int n = 5;
		
		Integer found = null;
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (arr[left] == n) {
				found = left;
				break;
			}
			if (arr[right] == n) {
				found = right;
				break;
			}
			if (arr[mid] == n) {
				found = mid;
				break;
			}
		
			if (arr[mid] > arr[left] && arr[mid] > arr[right]) {
				left = mid;
			} else if (arr[mid] < arr[left] && arr[mid] < arr[right]) {
				right = mid;
			} else {
				break;
			}
		}
		if (found != null) {
			System.out.println(found);
		}
		System.out.println(arr[mid]);
		if (n < arr[arr.length - 1]) {
			left = mid + 1;
			right = arr.length - 1;
		} else {
			left = 0;
			right = mid;
		}
		while (left < right) {
			mid = left + (right - left) / 2;
			if (arr[mid] == n) {
				found = mid;
				break;
			} else if (arr[mid] > n) {
				right = mid;
			} else {
				left = mid;
			}
		}
		System.out.println(found);
		System.out.println(arr[found]);
	}

}
