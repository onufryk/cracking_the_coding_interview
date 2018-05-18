/*
 * A circus is designing a tower routine consisting of people standing atop one another’s shoulders. 
 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
 * Given the heights and weights of each person in the circus, 
 * write a method to compute the largest possible number of people in such a tower.
 * 
 * EXAMPLE:
 * Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * 
 * Output: The longest tower is length 6 and includes from top to bottom: 
 * (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 */
package com.onufryk.crack.nine.seven;

import java.util.ArrayList;
import java.util.Arrays;

class Athlete implements Comparable<Athlete>{
	public int height;
	public int weight;
	public Athlete(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Athlete o) {
		if (o.height == this.height) {
			return this.weight - o.weight;
		}
		return this.height - o.height;
	}

	@Override
	public String toString() {
		return "(" + this.height + ", " + this.weight + ")";
	}
	
	
}

public class Question_09_07 {
	static ArrayList<Athlete> seqWithMaxLength(ArrayList<Athlete> seq1,ArrayList<Athlete> seq2) {
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}
	static int fillNextSeq(int startFrom, ArrayList<Athlete> seq, Athlete[] athletes) {
		int firstUnfitItem = startFrom;
		if (startFrom < athletes.length) {
			for (int i = 0; i < athletes.length; i++) {
				if (i == 0 || (athletes[i - 1].height < athletes[i].height && athletes[i - 1].weight < athletes[i].weight)) {
					seq.add(athletes[i]);
				} else {
					firstUnfitItem = i;
				}
			}
		}
		return firstUnfitItem;
	}

	public static void main(String[] args) {
		Athlete[] athletes = {
				new Athlete(65, 100),
				new Athlete(70, 150),
				new Athlete(56, 90),
				new Athlete(75, 190),
				new Athlete(60, 95),
				new Athlete(68, 110),
				};
		
		Arrays.sort(athletes);
		
		for (int i = 0; i < athletes.length; i++) {
			System.out.println(athletes[i]);
		}
		
		int currentUnfit = 0;
		ArrayList<Athlete> maxSequence = new ArrayList<Athlete>();
		while (currentUnfit < athletes.length) {
			ArrayList<Athlete> nextSequence = new ArrayList<Athlete>();
			int nextUnfit = fillNextSeq(currentUnfit, nextSequence, athletes);
			maxSequence = seqWithMaxLength(maxSequence, nextSequence);
			if (nextUnfit == currentUnfit) break;
			else currentUnfit = nextUnfit;
		}
		System.out.println("---");
		for (Athlete athlete : maxSequence) {
			System.out.println(athlete);
		}
	}

}
