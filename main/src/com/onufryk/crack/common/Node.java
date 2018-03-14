package com.onufryk.crack.common;

public class Node {
	public Node next = null;
	public Integer value = null;

	public Node(Integer value, Node next) {
		this.next = next;
		this.value = value;
	}

	public Node(Integer value) {
		this.next = null;
		this.value = value;
	}
}


