package com.onufryk.crack.common;

public class IntNode {
	public IntNode next = null;
	public Integer value = null;

	public IntNode(Integer value, IntNode next) {
		this.next = next;
		this.value = value;
	}

	public IntNode(Integer value) {
		this.next = null;
		this.value = value;
	}
}


