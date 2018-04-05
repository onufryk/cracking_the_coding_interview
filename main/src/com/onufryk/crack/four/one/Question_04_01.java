/*
 * Implement a function to check if a tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree such that no two leaf nodes differ 
 * in distance from the root by more than one.
 */
package com.onufryk.crack.four.one;


class Node {
	public Integer value;
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
	public Integer min;
	public Integer max;

	public Tree(Node root) {
		this.root = root;
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

	public Boolean isBalanced() {
		this.min = Integer.MAX_VALUE;
		this.max =  Integer.MIN_VALUE;
		this.calculateDistances(this.root, 0);
		return this.max - this.min <= 1;
	}

	private void calculateDistances(Node node, Integer distance) {
		if (node == null) {
			return;
		}
		if (distance > 0) {
			if (distance < this.min) {
				this.min = distance;
			}
			if (distance > this.max) {
				this.max = distance;
			}
		}
		this.calculateDistances(node.left, distance + 1);
		this.calculateDistances(node.right, distance + 1);
	}

}

public class Question_04_01 {

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
		System.out.println(tree.isBalanced());
	}

}
