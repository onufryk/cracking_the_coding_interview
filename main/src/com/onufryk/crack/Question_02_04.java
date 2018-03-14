package com.onufryk.crack;

import com.onufryk.crack.common.LinkedList;
import com.onufryk.crack.common.Node;

class DigitList extends LinkedList {

	public DigitList() {
		super();
	}

	public DigitList(Node root) {
		super(root);
	}
	
	public String toNumber() {
		if (this.root == null) {
			return null;
		}
		return this.toNumber(this.root);
	}
	
	private String toNumber(Node node) {
		if (node.next == null) {
			return node.value.toString();
		}
		return toNumber(node.next) + node.value.toString();
	}
	
	public static DigitList add(DigitList a, DigitList b) {
		DigitList sum = new DigitList();
		
		Node currentA = a.root;
		Node currentB = b.root;
		while (currentA != null && currentB != null) {
			sum.add(currentA.value + currentB.value);
			currentA = currentA.next;
			currentB = currentB.next;
		}
		if (currentA != null || currentB != null) {
			return null;
		}
		
		Node current = sum.root;
		while (current != null) {
			if (current.value > 9) {
				if (current.next == null) {
					current.value = current.value - 10;
					sum.add(1);
				} else {
					current.value = current.value - 10;
					current.next.value = current.next.value + 1;
				}
			}
			current = current.next;
		}
		
		return sum;
	}
	
}

public class Question_02_04 {

	public static void main(String[] args) {
		DigitList op1 = new DigitList(new Node(3, new Node(1, new Node(5))));
		DigitList op2 = new DigitList(new Node(5, new Node(9, new Node(2))));
		System.out.println(op1);
		System.out.println(op2);
		System.out.println("Calculating sum of:");
		System.out.println(op1.toNumber());
		System.out.println(op2.toNumber());
		
		DigitList sum = DigitList.add(op1, op2);
		System.out.println(sum);
		System.out.println(sum.toNumber());
	}

}
