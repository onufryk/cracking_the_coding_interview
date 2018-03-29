package com.onufryk.crack.four.five;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
	public Node root = null;

	public Node add(Integer value) {
		if (this.root == null) {
			this.root = new Node(value);
			return this.root;
		} else {
			return this.add(value, this.root);
		}
	}

	public Node add(Integer value, Node parent) {
		if (parent == null) {
			parent = new Node(value);
			return parent;
		}

		if (value < parent.value) {
			if (parent.left == null) {
				parent.left = new Node(value);
				parent.left.parent = parent;
				return parent.left;
			} else {
				return this.add(value, parent.left);
			}
		} else if (value > parent.value) {
			if (parent.right == null) {
				parent.right = new Node(value);
				parent.right.parent = parent;
				return parent.right;
			} else {
				return this.add(value, parent.right);
			}
		}
		return null;
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

	public Node minimal(Node node) {
		if (node.left == null) {
			return node;
		}
		return this.minimal(node.left);
	}
	
	public Node next(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return this.minimal(node.right);
		}
		
		if (node.left == null && node.right == null) {
			if (node.parent == null) {
				return null;
			}
			if (node.parent.value > node.value) {
				return node.parent;
			}
			if (node.parent.value <= node.value) {
				Node current = node;
				while (current.parent != null && current.parent.value < node.value) {
					current = current.parent;
				}
				return current.parent;
			}
		}
		
		if (node.left != null && node.right == null) {
			if (node.parent.value > node.value) {
				return node.parent;
			}
		}
		
		return null;
	}

}

public class Question_04_05 {
	/*
	 * Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a
	 * given node in a binary search tree where each node has a link to its
	 * parent.
	 */

	public static void main(String[] args) {
		ArrayList<Node> nodes = new ArrayList<>();
		Tree tree = new Tree();
		/*
		for (int ii = 0; ii < 10; ii++) {
			Integer value = ThreadLocalRandom.current().nextInt(1, 11);
			Node newNode = tree.add(value);
			if (newNode != null) {
				nodes.add(newNode);
			}
		}
		*/
		
		nodes.add(tree.add(6));
		nodes.add(tree.add(7));
		nodes.add(tree.add(9));
		nodes.add(tree.add(8));
		nodes.add(tree.add(10));
		nodes.add(tree.add(3));
		nodes.add(tree.add(1));
		nodes.add(tree.add(5));
		nodes.add(tree.add(2));

		System.out.print("Pre order: ");
		tree.traversePreOrder();
		System.out.println();
		System.out.print("In order: ");
		tree.traverseInOrder();
		System.out.println();
		System.out.print("Post order: ");
		tree.traversePostOrder();
		System.out.println();

		System.out.println(nodes);
		
		
		for (Node node : nodes) {
			System.out.print(node);
			System.out.print(" -> ");
			System.out.println(tree.next(node));
		}
	}

}
