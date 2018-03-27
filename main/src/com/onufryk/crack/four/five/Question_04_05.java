package com.onufryk.crack.four.five;

class Node {
	public Integer value;
	public Node parent;
	public Node left;
	public Node right;

	public Node(Integer value) {
		this.value = value;
	}

	public Node(Integer value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		if (this.value == null) {
			return null;
		}
		return this.value.toString();
	}
}

class Tree {
	public Node root;

	public Tree(Node root) {
		this.root = root;
	}
	
	public void add(Integer value) {
		
	}

	public void traverseInOrder() {
		this.traverseInOrder(this.root);
	}

	public void traversePreOrder() {
		this.traversePreOrder(this.root);
	}

	public void traversePostOrder() {
		this.traversePostOrder(this.root);
	}

	private void traverseInOrder(Node node) {
		if (node == null) {
			return;
		}
		this.traverseInOrder(node.left);
		System.out.print(node);
		System.out.print(" ");
		this.traverseInOrder(node.right);
	}

	private void traversePreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node);
		System.out.print(" ");
		this.traversePreOrder(node.left);
		this.traversePreOrder(node.right);
	}

	private void traversePostOrder(Node node) {
		if (node == null) {
			return;
		}
		this.traversePostOrder(node.left);
		this.traversePostOrder(node.right);
		System.out.print(node);
		System.out.print(" ");
	}


}


public class Question_04_05 {
	/*
	 * Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node 
	 * in a binary search tree where each node has a link to its parent.
	 */

	public static void main(String[] args) {
		Tree tree = new Tree(new Node(1, 
				new Node(2, 
						new Node(3,
								new Node(4), 
								new Node(5)
								), 
						new Node(6)
						),
				new Node(8, 
						new Node(9, 
								new Node(10), 
								new Node(11)
								), 
						new Node(12)
						)
				)
				);
		tree.traversePreOrder();
		System.out.println();
		tree.traverseInOrder();
		System.out.println();
		tree.traversePostOrder();
		System.out.println();
	}

}
