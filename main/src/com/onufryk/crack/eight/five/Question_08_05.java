/*
 * Implement an algorithm to print all valid (e.g., properly opened and closed) 
 * combinations of n-pairs of parentheses.
 * EXAMPLE:
 * input: 3 (e.g., 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((()))
 */
package com.onufryk.crack.eight.five;

import java.util.ArrayList;

class Parentheses {
	public Integer number = null;
	
	public Parentheses(Integer number) {
		this.number = number;
	}
	
	public void start() {
		this.start(this.number, new ArrayList<Integer>());
	}
	
	public void start(Integer n, ArrayList<Integer> prelist) {
		if (n == 0) {
			this.print(prelist);
			return;
		}
		for (int ii = n; ii > 0; ii--) {
			ArrayList<Integer> copy = (ArrayList<Integer>) prelist.clone();
			copy.add(ii);
			this.start(n - ii, copy);
		}
	}

	public void print(ArrayList<Integer> list) {
		String outer = "";
		for (Integer position : list) {
			String inner = "";
			for (int ii = 0; ii < position; ii++) {
				inner = "(".concat(inner).concat(")");
			}
			outer = outer.concat(inner);
		}
		System.out.println(outer);
	}
	
}

public class Question_08_05 {

	public static void main(String[] args) {
		Parentheses p = new Parentheses(5);
		p.start();
	}

}
