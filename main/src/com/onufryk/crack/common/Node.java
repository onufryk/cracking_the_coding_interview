package com.onufryk.crack.common;

public class Node<T> {
	public Node<T> next = null;
	public T value = null;

	public Node(T value, Node<T> next) {
		this.next = next;
		this.value = value;
	}

	public Node(T value) {
		this.next = null;
		this.value = value;
	}
}
