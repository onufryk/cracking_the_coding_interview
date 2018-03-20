package com.onufryk.crack;

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
			game = new TowersOfHanoi(5);
			System.out.println(game);

			game.move(1, 3);
			game.move(1, 2);
			
			game.move(3, 2);
			game.move(1, 3);

			game.move(2, 1);
			game.move(2, 3);

			game.move(1, 3);
			game.move(1, 2);

			game.move(3, 2);
			game.move(3, 1);

			game.move(2, 1);
			game.move(3, 2);

			game.move(1, 3);
			game.move(1, 2);

			game.move(3, 2);
			game.move(1, 3);

			game.move(2, 1);
			game.move(2, 3);

			game.move(1, 3);
			game.move(2, 1);

			game.move(3, 2);
			game.move(3, 1);

			game.move(2, 1);
			game.move(2, 3);

			game.move(1, 3);
			game.move(1, 2);

			game.move(3, 2);
			game.move(1, 3);

			game.move(2, 1);
			game.move(2, 3);

			game.move(1, 3);

			if (game.isEnd()) {
				System.out.println("Completed in " + game.moves + " moves.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
