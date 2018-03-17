package com.onufryk.crack.common;

public class IntLinkedList {
	protected IntNode root = null;

	public IntLinkedList() {
	}

	public IntLinkedList(IntNode root) {
		this.root = root;
	}
	
	public void add(Integer value) {
		if (this.root == null) {
			this.root = new IntNode(value);
			return;
		}
		IntNode current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new IntNode(value);
	}

	public IntLinkedList a(Integer value) {
		if (this.root == null) {
			this.root = new IntNode(value);
			return this;
		}
		IntNode current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new IntNode(value);
		return this;
	}
	
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		if (this.root == null) {
			return null;
		}
		IntNode current = this.root;
		while (current != null) {
			output.append(current.value);
			if (current.next != null) {
				output.append(" -> ");
			}
			current = current.next;
		}
		return output.toString();
	}

	public void dedupe() {
		if (this.root == null) {
			return;
		}
		IntNode outer = this.root;
		while (outer != null) {
			IntNode previous = outer;
			IntNode inner = previous.next;
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
