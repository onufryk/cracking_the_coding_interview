/*
 * Write a method that returns all subsets of a set.
 */
package com.onufryk.crack.eight.three;

import java.util.ArrayList;

public class Question_08_03 {

	public static void subsets(String set, ArrayList<String> accumulator) {
		subsetOfSize(set, accumulator, set.length());
	}

	public static void subsetOfSize(String set, ArrayList<String> accumulator, Integer size) {
		if (size == 0) {
			return;
		}
		if (size == set.length()) {
			if (!accumulator.contains(set)) {
				accumulator.add(set);
			}
		}
		for (int ii = 0; ii < set.length(); ii++) {
			subsetOfSize(set.substring(0, ii) + set.substring(ii + 1), accumulator, size - 1);
		}
	}

	public static void main(String[] args) {
		String set = "abc";
		ArrayList<String> subsets = new ArrayList<>();

		subsets(set, subsets);

		for (String item : subsets) {
			System.out.println(item);
		}
	}

}
