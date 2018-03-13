package com.onufryk.crack;

class Node {
	Node next = null;
	Integer value = null;

	public Node(Integer value, Node next) {
		this.next = next;
		this.value = value;
	}

	public Node(Integer value) {
		this.next = null;
		this.value = value;
	}
}

class LinkedList {
	private Node root = null;

	public LinkedList() {
	}

	public LinkedList(Node root) {
		this.root = root;
	}
	
	public void add(Integer value) {
		if (this.root == null) {
			this.root = new Node(value);
			return;
		}
		Node current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	public LinkedList a(Integer value) {
		if (this.root == null) {
			this.root = new Node(value);
			return this;
		}
		Node current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
		return this;
	}
	
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		if (this.root == null) {
			return null;
		}
		Node current = this.root;
		while (current != null) {
			output.append(current.value);
			if (current.next != null) {
				output.append(", ");
			}
			current = current.next;
		}
		return output.toString();
	}

	public void dedupe() {
		if (this.root == null) {
			return;
		}
		Node outer = this.root;
		while (outer != null) {
			Node previous = outer;
			Node inner = previous.next;
			while (inner != null) {

				if (inner.value == outer.value) {
					previous.next = inner.next;
					inner = previous.next;
				} else {
					previous = inner;
					inner = previous.next;
				}
			}

			outer = outer.next;
		}
	}

}

public class Question_02_01 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList().a(5).a(5).a(6).a(2).a(6).a(3).a(2).a(5).a(5);
		
		System.out.println(list);

		list.dedupe();

		System.out.println(list);
	}

}
