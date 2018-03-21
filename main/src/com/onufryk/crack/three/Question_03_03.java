package com.onufryk.crack.three;

import java.util.Map;
import java.util.HashMap;

class Node {
	public Integer value = null;
	public Node next = null;

	public Node(Integer value) {
		this.value = value;
	}

	public Node(Integer value, Node next) {
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}

class Stack {
	public Integer capacity = null;
	public Integer size = null;
	public Node top = null;
	public Stack next = null;

	public Stack(Integer capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public void push(Integer value) throws Exception {
		if (this.size == this.capacity) {
			throw new Exception("Stack capacity is exceeed");
		}
		Node newNode = new Node(value);
		newNode.next = this.top;
		this.top = newNode;
		this.size++;
	}

	public Integer pop() {
		if (this.top == null) {
			return null;
		}
		Integer topValue = this.top.value;
		this.top = this.top.next;
		this.size--;
		return topValue;
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Stack size = ");
		output.append(this.size);
		output.append(".");
		if (this.size > 0) {
			output.append(" Items: ");

			Node current = this.top;
			while (current != null) {
				output.append(current);
				if (current.next != null) {
					output.append(", ");
				}
				current = current.next;
			}
		}
		return output.toString();
	}
}

class SetOfStacks {
	public Integer size = null;
	public Integer stackCapacity = null;
	public Stack top = null;

	public Map<Integer, Stack> indexMap = null;

	public SetOfStacks(Integer stackCapacity) {
		this.stackCapacity = stackCapacity;
		this.size = 0;
		this.indexMap = new HashMap<Integer, Stack>();
	}

	public void push(Integer value) throws Exception {
		if (this.top == null) {
			this.top = new Stack(this.stackCapacity);
			this.indexMap.put(this.size, this.top);
			this.size++;
		}
		if (this.top.size == this.stackCapacity) {
			Stack newStack = new Stack(this.stackCapacity);
			newStack.next = this.top;
			this.top = newStack;
			this.indexMap.put(this.size, this.top);
			this.size++;
		}

		this.top.push(value);
	}

	public Integer pop() {
		if (this.top == null) {
			return null;
		}
		Integer value = this.top.pop();

		if (this.top.size == 0) {
			Stack next = this.top.next;
			this.top = next;
			
			this.indexMap.remove(this.size - 1);
			this.size--;
		}

		return value;
	}

	public Integer popAt(Integer index) {
		if (this.indexMap.containsKey(index)) {
			return this.indexMap.get(index).pop();
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("Set of stacks size = ");
		output.append(this.size);
		output.append(".");
		if (this.size > 0) {
			output.append(" Stacks: \n");
			Stack current = this.top;
			while (current != null) {
				output.append(current.toString());
				if (current.next != null) {
					output.append(";\n");
				}
				current = current.next;
			}
		}
		return output.toString();
	}

}

public class Question_03_03 {

	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks(5);
		try {
			for (int ii = 1; ii <= 12; ii++) {
				stacks.push(ii);
				System.out.println(stacks);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(stacks.popAt(1));
		System.out.println(stacks.popAt(0));

		for (int ii = 0; ii  <= 12; ii++) {
			System.out.println(stacks.pop());
			System.out.println(stacks);
			System.out.println();
		}

	}

}
