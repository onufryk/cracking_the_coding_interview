package com.onufryk.crack;

import com.onufryk.crack.common.LinkedList;
import com.onufryk.crack.common.Node;

class CorruptedList extends LinkedList {

	public CorruptedList() {
		super();
	}

	public CorruptedList(Node root) {
		super(root);
	}
	
	public Node getCircularLoopStart() {
		if (this.root == null) {
			return null;
		}
		Node doubleSpeed = this.root;
		Node normalSpeed = this.root;
		
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
		Node lastNode = new Node(5);
		Node loopNode = new Node(3, new Node(4, lastNode));
		lastNode.next = loopNode;
		
		CorruptedList list = new CorruptedList(new Node(1, new Node(2, loopNode)));
		Node circularLoopStart = list.getCircularLoopStart();
		if (circularLoopStart != null) {
			System.out.println("Circular reference detected at " + circularLoopStart.value);
		} else {
			System.out.println(list);
		}
		

	}

}

