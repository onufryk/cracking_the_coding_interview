package com.onufryk.crack;

import com.onufryk.crack.common.LinkedList;
import com.onufryk.crack.common.Node;

class RemovableList extends LinkedList {

	public RemovableList() {
		super();

	}

	public RemovableList(Node root) {
		super(root);
	}

	public void unlinkNode(Node node) {
		if (node == null) {
			return;
		}
		if (node.next == null) {
			return;
		}
		Node nextNode = node.next;
		if (nextNode != null) {
			node.value = nextNode.value;
			node.next = nextNode.next;
		}
	}

}

public class Question_02_03 {

	public static void main(String[] args) {
		Node anotherNodeToDelete = new Node(9);
		Node nodeToDelete = new Node(4, new Node(5, new Node(6, new Node(7, new Node(8, anotherNodeToDelete)))));
		RemovableList list = new RemovableList(new Node(1, new Node(2, new Node(3, nodeToDelete))));
		System.out.println(list);
		list.unlinkNode(anotherNodeToDelete);
		System.out.println(list);
		list.unlinkNode(nodeToDelete);
		System.out.println(list);
	}

}
