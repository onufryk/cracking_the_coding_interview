/*
 * Write a method to compute all permutations of a string.
 */
package com.onufryk.crack.eight.four;

import java.util.ArrayList;

public class Question_08_04 {
	public static ArrayList<String> permutations(String input) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (input.length() == 0) {
			return permutations;
		}
		if (input.length() == 1) {
			permutations.add(input);
			return permutations;
		}
		
		ArrayList<String> words = permutations(input.substring(1));
		for (String word : words) {
			for (int ii = 0; ii <= word.length(); ii++) {
				permutations.add(word.substring(0, ii) + input.substring(0, 1) + word.substring(ii));
			}

		}

		return permutations;
	}

	public static void main(String[] args) {
		String original = "abc";
		ArrayList<String> permutations = permutations(original);

		System.out.println("Permutations of " + original + ":");
		for (String item : permutations) {
			System.out.println(item);
		}
	}

}
