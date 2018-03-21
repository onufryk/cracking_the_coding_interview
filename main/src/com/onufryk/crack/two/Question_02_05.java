package com.onufryk.crack.two;

import com.onufryk.crack.common.IntLinkedList;
import com.onufryk.crack.common.IntNode;

class CorruptedList extends IntLinkedList {

	public CorruptedList() {
		super();
	}

	public CorruptedList(IntNode root) {
		super(root);
	}
	
	public IntNode getCircularLoopStart() {
		if (this.root == null) {
			return null;
		}
		IntNode doubleSpeed = this.root;
		IntNode normalSpeed = this.root;
		
		while (doubleSpeed.next != null) {
			doubleSpeed = doubleSpeed.next.next;
			normalSpeed = normalSpeed.next;
			
			if (doubleSpeed == normalSpeed) {
				break;
			}
		}
		
		if (doubleSpeed.next == null)
			return null;
		
		normalSpeed = this.root;
		
		while (normalSpeed != doubleSpeed) {
			normalSpeed = normalSpeed.next;
			doubleSpeed = doubleSpeed.next;
		}
		return doubleSpeed;
	}
	
	
	
}

public class Question_02_05 {
	// 1 2 3 4 5 3

	public static void main(String[] args) {
		IntNode lastNode = new IntNode(5);
		IntNode loopNode = new IntNode(3, new IntNode(4, lastNode));
		lastNode.next = loopNode;
		
		CorruptedList list = new CorruptedList(new IntNode(1, new IntNode(2, loopNode)));
		IntNode circularLoopStart = list.getCircularLoopStart();
		if (circularLoopStart != null) {
			System.out.println("Circular reference detected at " + circularLoopStart.value);
		} else {
			System.out.println(list);
		}
		

	}

}

