package com.onufryk.crack.two;

import com.onufryk.crack.common.IntLinkedList;
import com.onufryk.crack.common.IntNode;

class DigitList extends IntLinkedList {

	public DigitList() {
		super();
	}

	public DigitList(IntNode root) {
		super(root);
	}
	
	public String toNumber() {
		if (this.root == null) {
			return null;
		}
		return this.toNumber(this.root);
	}
	
	private String toNumber(IntNode intNode) {
		if (intNode.next == null) {
			return intNode.value.toString();
		}
		return toNumber(intNode.next) + intNode.value.toString();
	}
	
	public static DigitList add(DigitList a, DigitList b) {
		DigitList sum = new DigitList();
		
		IntNode currentA = a.root;
		IntNode currentB = b.root;
		while (currentA != null && currentB != null) {
			sum.add(currentA.value + currentB.value);
			currentA = currentA.next;
			currentB = currentB.next;
		}
		if (currentA != null || currentB != null) {
			return null;
		}
		
		IntNode current = sum.root;
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
		DigitList op1 = new DigitList(new IntNode(3, new IntNode(1, new IntNode(5))));
		DigitList op2 = new DigitList(new IntNode(5, new IntNode(9, new IntNode(2))));
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
