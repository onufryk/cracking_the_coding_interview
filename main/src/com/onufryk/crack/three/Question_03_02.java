package com.onufryk.crack.three;

class MinLinkNode<T extends Comparable<T>> {
	public T value = null;
	public MinLinkNode<T> next = null;
	public MinLinkNode<T> previous = null;
	public T min = null;
	

	public MinLinkNode(T value) {
		this.value = value;
	}
}

class MinStack<T extends Comparable<T>> {
	protected MinLinkNode<T> root = null;
	protected MinLinkNode<T> head = null;
	

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		if (this.root == null) {
			return null;
		}
		MinLinkNode<T> current = this.root;
		while (current != null) {
			output.append(current.value);
			if (current.next != null) {
				output.append(" -> ");
			}
			current = current.next;
		}
		return output.toString();
	}

	public void push(T value) {
		MinLinkNode<T> newNode = new MinLinkNode<>(value);

		if (this.root == null) {
			newNode.min = value;
			this.root = newNode;
		} else {
			MinLinkNode<T> previous = this.head;
			
			if (value.compareTo(previous.min) <= 0) {
				newNode.min = value;
			} else {
				newNode.min = previous.min;
			}
			
			newNode.previous = previous;
			previous.next = newNode;
		}
		this.head = newNode;
	}

	public T pop() {
		if (this.head == null) {
			return null;
		}
		T value = this.head.value;
		if (this.head.previous == null) {
			this.head = null;
			this.root = null;
		} else {
			this.head = this.head.previous;
			this.head.next = null;
		}
		return value;
	}

	public T peek() {
		if (this.head == null) {
			return null;
		}
		return this.head.value;
	}

	public T min() {
		if (this.head == null) {
			return null;
		}
		return this.head.min;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
}

public class Question_03_02 {

	public static void main(String[] args) {
		MinStack<Integer> stack = new MinStack<>();
		stack.push(4);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(7);
		stack.push(6);
		stack.push(3);
		stack.push(8);
		stack.push(2);
		
		while (!stack.isEmpty()) {
			System.out.println("MIN: " + stack.min() + " POP: " + stack.pop());
		}
	}

}
