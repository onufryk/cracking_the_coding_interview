/*
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes 
 * which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size 
 * from top to bottom (e.g., each disk sits on top of an even larger one).
 * You have the following constraints:
 *  (A) Only one disk can be moved at a time.
 *  (B) A disk is slid off the top of one rod onto the next rod.
 *  (C) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first rod to the last using Stacks.
 */
package com.onufryk.crack.three;

class TowerNode {
	public Integer value = null;
	public TowerNode next = null;

	public TowerNode(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		if (this.value == null) {
			return null;
		}
		return this.value.toString();
	}

}

class Tower {
	public Integer size = null;
	public Integer capacity = null;
	public TowerNode top = null;

	public Tower(Integer capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.top = null;
	}

	public void push(Integer value) throws Exception {
		if (this.isFull()) {
			throw new Exception("The tower is full.");
		}
		if (this.top != null && value > this.top.value) {
			throw new Exception("Can not put larger disc on top of smaller.");
		}
		TowerNode newNode = new TowerNode(value);
		newNode.next = this.top;
		this.top = newNode;
		this.size++;
	}

	public Integer pop() {
		if (this.isEmpty()) {
			return null;
		}
		Integer value = this.top.value;
		this.top = this.top.next;
		this.size--;
		return value;
	}

	public Integer pick() {
		if (this.top == null) {
			return null;
		}
		return this.top.value;
	}

	public Boolean isEmpty() {
		return this.size == 0;
	}

	public Boolean isFull() {
		return this.size == this.capacity;
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Size = ");
		output.append(this.size);
		output.append(".");
		if (this.size > 0) {
			output.append(" Items: ");

			TowerNode current = this.top;
			while (current != null) {
				output.append(current);
				if (current.next != null) {
					output.append(", ");
				}
				current = current.next;
			}
		}
		return output.toString();
	}
}

class TowersOfHanoi {
	public Tower[] towers = null;
	public Integer numberOfDiscs = null;
	public Integer moves = null;

	public TowersOfHanoi(Integer numberOfDiscs) throws Exception {
		this.moves = 0;
		this.numberOfDiscs = numberOfDiscs;
		this.towers = new Tower[3];
		for (int ii = 0; ii < 3; ii++) {
			this.towers[ii] = new Tower(numberOfDiscs);
		}
		for (int ii = numberOfDiscs; ii > 0; ii--) {
			this.towers[0].push(ii);
		}
	}

	public Boolean isStart() {
		return this.towers[0].isFull();
	}

	public Boolean isEnd() {
		return this.towers[2].isFull();
	}

	public void move(Integer from, Integer to) throws Exception {
		System.out.println("Trying to move from tower " + from + " to tower " + to + ".");
		if (from == null || from < 1 || from > 3) {
			throw new Exception("Invalid move");
		}
		if (to == null || to < 1 || to > 3) {
			throw new Exception("Invalid move");
		}
		if (this.towers[from - 1].isEmpty()) {
			throw new Exception("Invalid move");
		}
		Integer value = this.towers[from - 1].pop();
		this.towers[to - 1].push(value);
		System.out.println("Moving " + value + " from tower " + from + " to tower " + to + ".");
		this.moves++;
		System.out.println(this);
	}

	public void start() throws Exception {
		this.move(this.numberOfDiscs, 1, 3, 2);
	}

	public void move(Integer n, Integer from, Integer to, Integer aux) throws Exception {
		if (n > 0) {
			System.out.println("Moving " + n + " discs from " + from + " to " + to + " (temp: " + aux + ").");
			this.move(n - 1, from, aux, to);
			this.move(from, to);
			this.move(n - 1, aux, to, from);
		}
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();

		for (int ii = 0; ii < 3; ii++) {
			output.append("Tower " + (ii + 1) + ": ");
			output.append(this.towers[ii]);
			output.append("\n");
		}

		return output.toString();
	}

}

public class Question_03_04 {

	public static void main(String[] args) {

		TowersOfHanoi game = null;
		try {
			game = new TowersOfHanoi(24);
			System.out.println(game);
			
			game.start();

			if (game.isEnd()) {
				System.out.println("Completed in " + game.moves + " moves.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
