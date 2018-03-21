package com.onufryk.crack.two;

import com.onufryk.crack.common.IntLinkedList;
import com.onufryk.crack.common.IntNode;

class RemovableList extends IntLinkedList {

	public RemovableList() {
		super();

	}

	public RemovableList(IntNode root) {
		super(root);
	}

	public void unlinkNode(IntNode intNode) {
		if (intNode == null) {
			return;
		}
		if (intNode.next == null) {
			return;
		}
		IntNode nextNode = intNode.next;
		if (nextNode != null) {
			intNode.value = nextNode.value;
			intNode.next = nextNode.next;
		}
	}

}

public class Question_02_03 {

	public static void main(String[] args) {
		IntNode anotherNodeToDelete = new IntNode(9);
		IntNode nodeToDelete = new IntNode(4, new IntNode(5, new IntNode(6, new IntNode(7, new IntNode(8, anotherNodeToDelete)))));
		RemovableList list = new RemovableList(new IntNode(1, new IntNode(2, new IntNode(3, nodeToDelete))));
		System.out.println(list);
		list.unlinkNode(anotherNodeToDelete);
		System.out.println(list);
		list.unlinkNode(nodeToDelete);
		System.out.println(list);
	}

}
