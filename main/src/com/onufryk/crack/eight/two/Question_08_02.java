/*
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * FOLLOW UP
 * Imagine certain squares are “off limits”, such that the robot can not step on them. 
 * Design an algorithm to get all possible paths for the robot.
 */
package com.onufryk.crack.eight.two;

public class Question_08_02 {
	public static Integer start(Integer limit) {
		return move(0, 0, limit);
	}
	
	public static Integer move(Integer i, Integer j, Integer limit) {
		Integer in = 0;
		Integer jn = 0;
		if (i < limit - 1) {
			in = move(i + 1, j, limit);
		}
		if (j < limit - 1) {
			jn = move(i, j + 1, limit);
		}
		return in + jn + 1;
	}

	public static void main(String[] args) {
		System.out.println(start(2));
		System.out.println(start(3));
	}

}
