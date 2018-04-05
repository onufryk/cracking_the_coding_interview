/*
 * Implement a MyQueue class which implements a queue using two stacks.
 */
package com.onufryk.crack.three.five;

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
	public Integer size = null;
	public Node top = null;
	
	public Stack() {
		this.size = 0;
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
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Stack size = ");
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

class Queue {
	private Stack main = null;
	private Stack aux = null;
	
	public Queue() {
		this.main = new Stack();
		this.aux = new Stack();
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Main stack. ");
		output.append(this.main.toString());
		output.append("\n");
		output.append("Aux stack. ");
		output.append(this.aux.toString());
		output.append("\n");
		return output.toString();
	}
	
	public void enqueue(Integer value) {
		this.main.push(value);
	}
	
	public Integer dequeue() {
		while (!this.main.isEmpty()) {
			this.aux.push(this.main.pop());
		}
		Integer value = this.aux.pop();
		while (!this.aux.isEmpty()) {
			this.main.push(this.aux.pop());
		}
		return value;
	}
	
}

public class Question_03_05 {

	public static void main(String[] args) {
		Queue queue = new Queue();
		
		System.out.println(queue);
		for (int ii = 1; ii <= 8; ii++) {
			queue.enqueue(ii);
			System.out.println("-----\nAdding " + ii);
			System.out.println(queue);
		}
		
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		queue.enqueue(17);
		queue.enqueue(15);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
	}

}
