/*
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1.
 */
package com.onufryk.crack.four.seven;

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

	public Boolean isSubtree(Tree t2) {
		if (t2.root == null) {
			return true;
		}
		return this.isSubtree(this.root, t2.root);
	}

	private Boolean isSubtree(Node t1, Node t2) {
		if (t2 == null) {
			return true;
		}
		return this.subtree(t1, t2);
	}

	private Boolean subtree(Node t1, Node t2) {
		if (t1 == null) {
			return false;
		}
		if (t1.value == t2.value) {
			if (this.matchTree(t1, t2)) {
				return true;
			}
		}
		return (this.subtree(t1.left, t2) || this.subtree(t1.right, t2));
	}

	private Boolean matchTree(Node t1, Node t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.value != t2.value) {
			return false;
		}
		return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
	}
}

public class Question_04_07 {

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

		Node node11a = new Node(11);
		Node node10a = new Node(10);
		Node node9a = new Node(9, node10a, node11a);
		Tree tree2 = new Tree(node9a);

		System.out.println();
		System.out.println(tree1.isSubtree(tree2));
	}

}
