/*
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */
package com.onufryk.crack.four.three;

import java.util.ArrayList;


class Node {
	public Integer value;
	public Node left;
	public Node right;
	
	public Node(Integer value) {
		this.value = value;
		
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}

class Tree {
	public Node root;

	public Tree(Node root) {
		this.root = root;
	}
	
	public Tree() {
	}
	
	public void addNumbers(ArrayList<Integer> numbers) {
		this.root = this.addSubTree(numbers, 0, numbers.size() - 1);
	}
	
	private Node addSubTree(ArrayList<Integer> numbers, Integer start, Integer end) {
		if (end < start) {
			return null;
		}
		
		Integer middle = (start + end) / 2;
		Node newNode = new Node(numbers.get(middle));
		newNode.left = this.addSubTree(numbers, start, middle - 1);
		newNode.right = this.addSubTree(numbers, middle + 1, end);
		
		return newNode;
	}
	
	public void traversePreOrder() {
		this.traversePreOrder(this.root);
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
	
}

public class Question_04_03 {
	

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(5);
		numbers.add(7);
		numbers.add(15);
		numbers.add(55);
		numbers.add(56);
		numbers.add(500);
		numbers.add(501);
		numbers.add(502);
		
		System.out.println(numbers);
		
		Tree tree = new Tree();
		tree.addNumbers(numbers);
		tree.traversePreOrder();

	}

}
