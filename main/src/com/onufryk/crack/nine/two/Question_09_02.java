/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
package com.onufryk.crack.nine.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class AnagramString implements Comparable<AnagramString> {
	private String value = null;
	public String normalized = null;
	
	public AnagramString(String value) {
		this.value = value;
		char[] asChars = value.toCharArray();
		Arrays.sort(asChars);
		this.normalized = new String(asChars);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}


	@Override
	public int compareTo(AnagramString anotherString) {
		return this.normalized.compareTo(anotherString.normalized);
	}
	
}

public class Question_09_02 {


	public static void main(String[] args) {
		ArrayList<AnagramString> strings = new ArrayList<>();
		strings.add(new AnagramString("a"));
		strings.add(new AnagramString("longest"));
		strings.add(new AnagramString("ab"));
		strings.add(new AnagramString("abc"));
		strings.add(new AnagramString("banan"));
		strings.add(new AnagramString("abanan"));
		strings.add(new AnagramString("bananas"));
		strings.add(new AnagramString("banana"));
		
		Collections.sort(strings);
		
		for (AnagramString item : strings) {
			System.out.println(item);
		}

	}

}
