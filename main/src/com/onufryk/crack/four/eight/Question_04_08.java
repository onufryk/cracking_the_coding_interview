/*
 * You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum up to that value. 
 * Note that it can be any path in the tree - it does not have to start at the root.
 */
package com.onufryk.crack.four.eight;

import java.util.ArrayList;

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
	
	public void findPaths(Integer target) {
		this.processNode(this.root, target);
	}

	private void processNode(Node node, Integer target) {
		if (node == null) {
			return;
		}
		this.findPaths(node, target, 0, new ArrayList<Integer>());
		this.processNode(node.left, target);
		this.processNode(node.right, target);
	}
	
	@SuppressWarnings("unchecked")
	private void findPaths(Node node, Integer target, Integer sum, ArrayList<Integer> buffer) {
		if (node == null) {
			return;
		}
		sum = sum + node.value;
		buffer.add(node.value);
		if (sum > target) {
			return;
		}
		if (sum == target) {
			System.out.println(buffer);
			return;
		}
		this.findPaths(node.left, target, sum, (ArrayList<Integer>) buffer.clone());
		this.findPaths(node.right, target, sum, (ArrayList<Integer>) buffer.clone());
	}
}

public class Question_04_08 {

	public static void main(String[] args) {
		/*
		 *           1
		 *      2            8
		 *   3    6      9      12
		 * 4   5      10   11
 		 */
		Node node12 = new Node(12);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node9 = new Node(9, node10, node11);
		Node node8 = new Node(8, node9, node12);
		Node node6 = new Node(6);
		Node node5 = new Node(5);
		Node node4 = new Node(4);
		Node node3 = new Node(3, node4, node5);
		Node node2 = new Node(2, node3, node6);
		Node node1 = new Node(1, node2, node8);
		Tree tree1 = new Tree(node1);
		tree1.traversePreOrder();
		System.out.println();
		
		tree1.findPaths(10);

	}

}
