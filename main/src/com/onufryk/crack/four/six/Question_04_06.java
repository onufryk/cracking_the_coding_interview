/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. 
 * 
 * NOTE: This is not necessarily a binary search tree.
 */
package com.onufryk.crack.four.six;

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
	
	public Boolean isChild(Node parent, Node child) {
		if (parent == null) {
			return false;
		}
		if (parent == child) {
			return true;
		}
		if (parent.left == child) {
			return true;
		}
		if (parent.right == child) {
			return true;
		}
		return this.isChild(parent.left, child) || this.isChild(parent.right, child);
	}
	
	public Node getParentUnder(Node parent, Node child) {
		if (parent.left == child || parent.right == child) {
			return parent;
		}
		if (parent.left != null) {
			Node parentUnderLeft = getParentUnder(parent.left, child);
			if (parentUnderLeft != null) {
				return parentUnderLeft;
			}
		}
		if (parent.right != null) {
			Node parentUnderRight = getParentUnder(parent.right, child);
			if (parentUnderRight != null) {
				return parentUnderRight;
			}
		}
		
		return null;
	}
	
	public Node getFirstCommonParent(Node n1, Node n2) {
		return this.getFirstCommonParent(this.root, n1, n2);
//		System.out.println(this.getParentUnder(this.root.left, n1));
//		System.out.println(this.getParentUnder(this.root.left, n2));
//		System.out.println();
//		System.out.println(this.getParentUnder(this.root.left.left, n1));
//		System.out.println(this.getParentUnder(this.root.left.left, n2));
//		System.out.println();
//		System.out.println(this.getParentUnder(this.root.left.right, n1));
//		System.out.println(this.getParentUnder(this.root.left.right, n2));
//		System.out.println();
//		System.out.println(this.getParentUnder(this.root.right, n1));
//		System.out.println(this.getParentUnder(this.root.right, n2));
	}
	
	private Node getFirstCommonParent(Node parent, Node n1, Node n2) {
		if (parent == null) {
			return null;
		}
		if (parent == n1) {
			return parent;
		}
		if (parent == n2) {
			return parent;
		}
		
		Node node1parent = this.getParentUnder(parent, n1);
		Node node2parent = this.getParentUnder(parent, n2);
		
		if (node1parent == node2parent) {
			return node1parent;
		}
		
		Node next1 = this.getFirstCommonParent(parent, node1parent, n2);
		Node next2 = this.getFirstCommonParent(parent, n1, node2parent);
		
		if (next1 != null) {
			return next1;
		}
		if (next2 != null) {
			return next2;
		}
		
		return null;
	}
}

public class Question_04_06 {
	/*
	 * Design an algorithm and write code to find the first common ancestor of two
	 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
	 * 
	 * NOTE: This is not necessarily a binary search tree.
	 */
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
		Tree tree = new Tree(node1);
		tree.traversePreOrder();
		System.out.println();
		System.out.println(tree.getFirstCommonParent(node10, node5));
	}

}
