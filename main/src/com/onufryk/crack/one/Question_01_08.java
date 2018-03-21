package com.onufryk.crack.one;

/*
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring 
 * (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class Question_01_08 {
	public static Boolean isSubstring(String needle, String haystack) {
		return (haystack.indexOf(needle) >= 0);
	}
	
	public static Boolean isRotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		String doubleStr = str1 + str1;
		return isSubstring(str2, doubleStr);
	}

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		if (isRotation(s1, s2)) {
			System.out.println("Strings are rotations of one another.");
		} else {
			System.out.println("String are not rotations of one another.");
		}

	}

}
