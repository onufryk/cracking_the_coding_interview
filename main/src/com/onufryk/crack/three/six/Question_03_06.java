package com.onufryk.crack.three.six;
import java.util.concurrent.ThreadLocalRandom;

class Node {
	public Integer value = null;
	public Node next = null;

	public Node(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}

class Stack {
	private String name = null;
	public Integer size = null;
	public Node top = null;
	
	public Stack(String name) {
		this.size = 0;
		this.name = name;
	}
	
	public void push(Integer value) {
		Node newNode = new Node(value);
		newNode.next = this.top;
		this.top = newNode;
		this.size++;
	}
	
	public Integer pop() {
		if (this.top == null) {
			return null;
		}
		Integer topValue = this.top.value;
		this.top = this.top.next;
		this.size--;
		return topValue;
	}
	
	public Integer peek() {
		if (this.top == null) {
			return null;
		}
		return this.top.value;
	}
	
	public Boolean isEmpty() {
		return this.size == 0;
	}
	
	public void sort() {
		Stack aux = new Stack("aux");
		while (!this.isEmpty()) {
			Integer value = this.pop();
			aux.push(value);
		}
		while (!aux.isEmpty()) {
			Integer value = aux.pop();
			while (!this.isEmpty() && this.peek() > value) {
				aux.push(this.pop());
			}
			this.push(value);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Stack " + this.name + " size = ");
		output.append(this.size);
		output.append(".");
		if (this.size > 0) {
			output.append(" Items: ");

			Node current = this.top;
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
public class Question_03_06 {

	public static void main(String[] args) {
		Stack main = new Stack("main");
		for (int ii = 0; ii < 10; ii++) {
			main.push(ThreadLocalRandom.current().nextInt(1, 11));
		}
		System.out.println(main);
		main.sort();
		System.out.println(main);
	}

}
