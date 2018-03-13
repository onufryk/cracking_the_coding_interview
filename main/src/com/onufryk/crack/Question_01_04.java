package com.onufryk.crack;

import java.util.HashMap;
import java.util.Map;

/*
 * Write a method to decide if two strings are anagrams or not.
 */
public class Question_01_04 {
	
	public static Boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
		for (int ii = 0; ii < str1.length(); ii++) {
			Character char1 = str1.charAt(ii);
			Character char2 = str2.charAt(ii);
			
			if (!frequencies.containsKey(char1)) {
				frequencies.put(char1, 0);
			}
			if (!frequencies.containsKey(char2)) {
				frequencies.put(char2, 0);
			}
			frequencies.put(char1, frequencies.get(char1) + 1);
			frequencies.put(char2, frequencies.get(char2) + 1);
		}
		for (Character c : frequencies.keySet()) {
			if (frequencies.get(c) % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "silent";
		String str2 = "listen";

		if (areAnagrams(str1, str2)) {
			System.out.println("Strings are anagrams.");
		} else {
			System.out.println("Strings are not anagrams.");
		}
	}

}
