package com.onufryk.crack.four.four;

import java.util.ArrayList;

class Node {
	public Integer value = null;
	public Node left = null;
	public Node right = null;
	public Node next = null;
	public Node nextInTheQueue = null;
	public Boolean visited = null;
	public Integer level = null;
	
	public Node(Integer value) {
		this.value = value;
		this.visited = false;
	}
	public Node(Integer value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.visited = false;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}

class Queue {
	public Node head = null;
	public Node tail = null;
	
	public void enqueue(Node node) {
		Node lastNode = this.tail;
		
		this.tail = node;
		
		if (this.head == null) {
			this.head = node;
		} else {
			lastNode.nextInTheQueue = node;
		}
	}
	
	public Node dequeue() {
		if (this.head == null) {
			return null;
		}
		Node first = head;
		
		this.head = this.head.nextInTheQueue;
		
		if (this.head == null) {
			this.tail = null;
		}
		
		return first;
	}

	public Node peek() {
		if (this.head == null) {
			return null;
		}
		return this.head;
	}
	
	@Override
	public String toString() {
		if (this.head == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		Node cursor = this.head;
		while (cursor != null) {
			buffer.append(cursor.value);
			buffer.append(' ');
			cursor = cursor.nextInTheQueue;
		}
		return buffer.toString();
	}
	
}

class LinkedList {
	public Node root = null;
	
	public void add(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			Node current = this.root;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		if (this.root == null) {
			return null;
		}
		Node current = this.root;
		while (current != null) {
			output.append(current.value);
			if (current.next != null) {
				output.append(" -> ");
			}
			current = current.next;
		}
		return output.toString();
	}
	
}

class Tree {
	public Node root = null;
	
	private Queue queue = null;
	
	private ArrayList<LinkedList> leveledLists = new ArrayList<>();
	
	public Tree(Node root) {
		this.root = root;
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
	
	public void breadthFirst() {
		if (this.root == null) {
			return;
		}
		if (this.root.visited) {
			return;
		}
		this.root.level = 0;
		this.queue = new Queue();
		this.queue.enqueue(this.root);
		this.breadthFirstIteration();
	}
	
	private void breadthFirstIteration() {
		if (this.queue == null) {
			return;
		}
		Node current = this.queue.dequeue();
		if (current == null) {
			return;
		}
		if (this.leveledLists.isEmpty()) {
			LinkedList list = new LinkedList();
			list.add(current);
			this.leveledLists.add(current.level, list);
		} else {
			if (this.leveledLists.size() <= current.level) {
				this.leveledLists.add(current.level, new LinkedList());
			}
			this.leveledLists.get(current.level).add(current);
		}
		current.visited = true;

		System.out.print(current.value);
		System.out.print(" ");
		
		if (current.left != null && current.left.visited == false) {
			current.left.level = current.level + 1;
			this.queue.enqueue(current.left);
		}
		if (current.right != null && current.right.visited == false) {
			current.right.level = current.level + 1;
			this.queue.enqueue(current.right);
		}
		this.breadthFirstIteration();
	}
	
	public void lists() {
		System.out.println("Lists by level");
		for (LinkedList list : this.leveledLists) {
			System.out.println(list);
		}
	}
}

public class Question_04_04 {
	public static void main(String[] args) {
		Tree tree = new Tree(
				new Node(56, 
						new Node(15, 
								new Node(7, 
										new Node(5), 
										null
										), 
								new Node(55)
								), 
						new Node(501, 
								new Node(500), 
								new Node(502)
								)
						)
				);
		tree.traversePreOrder();
		System.out.println();
		
		tree.breadthFirst();
		System.out.println();
		
		tree.lists();
				
	}
}
