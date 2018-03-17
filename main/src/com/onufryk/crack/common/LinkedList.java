package com.onufryk.crack.common;

public class LinkedList<T> {
	protected Node<T> root = null;


	public LinkedList() {
	}

	public LinkedList(Node<T> root) {
		this.root = root;
	}
	
	public void add(T value) {
		if (this.root == null) {
			this.root = new Node<T>(value);
			return;
		}
		Node<T> current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node<T>(value);
	}

	public LinkedList<T> a(T value) {
		if (this.root == null) {
			this.root = new Node<T>(value);
			return this;
		}
		Node<T> current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node<T>(value);
		return this;
	}
	
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		if (this.root == null) {
			return null;
		}
		Node<T> current = this.root;
		while (current != null) {
			output.append(current.value);
			if (current.next != null) {
				output.append(" -> ");
			}
			current = current.next;
		}
		return output.toString();
	}
}
