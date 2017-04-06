package com.onufryk.crack;

import java.util.HashMap;
import java.util.Map;

/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 */
public class Question_01_01 {
	
	public static Boolean areAllCharactersUnique(String str) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (freq.containsKey(str.charAt(i))) {
				return false;
			}
			freq.put(str.charAt(i), 1);
		}
		return true;
	}
	
	public static Boolean areAllCharactersUnique_bruteforce(String str) {
		for (int ii = 0; ii < str.length() - 1; ii++) {
			Character charI = str.charAt(ii);
			for (int jj = ii + 1; jj < str.length(); jj++) {
				if (str.charAt(jj) == charI) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String input = "abcdefghijklmnopqdrstuvwxyz";
		
		if (areAllCharactersUnique(input)) {
			System.out.println("All characters are unique.");
		} else {
			System.out.println("Characters are NOT unique.");
		}
		if (areAllCharactersUnique_bruteforce(input)) {
			System.out.println("All characters are unique.");
		} else {
			System.out.println("Characters are NOT unique.");
		}		
	}

}
