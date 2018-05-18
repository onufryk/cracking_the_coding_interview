/*
 * Given a sorted array of strings which is interspersed with empty strings, 
 * write a method to find the location of a given string.
 * 
 * Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
 * Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 */
package com.onufryk.crack.nine.five;

public class Question_09_05 {
	public static int findFast(String[] arr, String target) {
		int left = 0;
		int right = arr.length - 1;
		int mid = -1;
		
		while (left < right) {
			while (arr[left] == "" && left < arr.length - 1) {
				left++;
			}
			
			while (arr[right] == "" && right >0) {
				right--;			
			}
			if (arr[right] == target) {
				return right;
			}
			if (arr[left] == target) {
				return left;
			}
			
			mid = left + (right - left) / 2;
			
			if (arr[mid] == "") {
				while (arr[mid] == "" && mid > left ) {
					mid--;
				}
				if (mid == left) {
					mid++;
					while (arr[mid] == "" && mid < right) {
						mid++;
					}
				}
				if (mid == right) {
					return -1;
				}
			}
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid].compareTo(target) > 0) {
				right = mid;
			} else {
				left = mid;
			}
			
			
			
		}
		return -1;
	}
	public static int findSlow(String[] arr, String target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String arr[] = new String[] {
				"at",
				"",
				"",
				"",
				"ball",
				"",
				"",
				"car",
				"",
				"",
				"dad",
				"",
				""
		};
		System.out.println(findFast(arr, "ball"));
		System.out.println(findFast(arr, "ballcar"));
	}

}
