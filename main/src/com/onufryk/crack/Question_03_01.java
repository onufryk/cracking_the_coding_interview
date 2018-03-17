package com.onufryk.crack;

enum StackIndex {
	FIRST, SECOND, THIRD
}

class TrippleStack {
	private Integer allocationFirst = null;
	private Integer allocationSecond = null;
	private Integer allocationThird = null;

	private Integer sizeFirst = null;
	private Integer sizeSecond = null;
	private Integer sizeThird = null;

	private Integer[] container = null;

	public TrippleStack(Integer first, Integer second, Integer third) {
		this.allocationFirst = first;
		this.allocationSecond = second;
		this.allocationThird = third;

		this.sizeFirst = 0;
		this.sizeSecond = 0;
		this.sizeThird = 0;

		Integer largestAllocation = Math.max(this.allocationFirst, Math.max(this.allocationSecond, this.allocationThird));
		this.container = new Integer[largestAllocation * 3];
	}

	public void push(StackIndex index, Integer value) {
		switch (index) {
		case FIRST:
			if (this.sizeFirst == this.allocationFirst) {
				System.out.println("Stack 1 is full. Skipping.");
				return;
			}
			this.container[this.sizeFirst * 3] = value;
			this.sizeFirst++;
			break;
		case SECOND:
			if (this.sizeSecond == this.allocationSecond) {
				System.out.println("Stack 2 is full. Skipping.");
				return;
			}
			this.container[this.sizeSecond * 3 + 1] = value;
			this.sizeSecond++;
			break;
		case THIRD:
			if (this.sizeThird == this.allocationThird) {
				System.out.println("Stack 3 is full. Skipping.");
				return;
			}
			this.container[this.sizeThird * 3 + 2] = value;
			this.sizeThird++;
			break;
		}

	}

	public Integer pop(StackIndex index) {
		switch (index) {
		case FIRST:
			if (this.sizeFirst == 0) {
				System.out.println("Stack 1 is empty. Skipping.");
				return null;
			}
			this.sizeFirst--;
			return this.container[this.sizeFirst * 3];
		case SECOND:
			if (this.sizeSecond == 0) {
				System.out.println("Stack 2 is empty. Skipping.");
				return null;
			}
			this.sizeSecond--;
			return this.container[this.sizeSecond * 3 + 1];
		case THIRD:
			if (this.sizeThird == 0) {
				System.out.println("Stack 3 is empty. Skipping.");
				return null;
			}
			this.sizeThird--;
			return this.container[this.sizeThird * 3 + 2];
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();

		if (this.sizeFirst > 0) {
			output.append("Stack 1, size " + this.sizeFirst + ": ");
			for (int ii = 0; ii < this.sizeFirst; ii++) {
				output.append(this.container[ii * 3]);
				output.append(" ");
			}
			output.append(".\n");
		} else {
			output.append("Stack 1 is empty.\n");
		}
		if (this.sizeSecond > 0) {
			output.append("Stack 2, size " + this.sizeSecond + ": ");
			for (int ii = 0; ii < this.sizeSecond; ii++) {
				output.append(this.container[ii * 3 + 1]);
				output.append(" ");
			}
			output.append(".\n");
		} else {
			output.append("Stack 2 is empty.\n");
		}
		if (this.sizeThird > 0) {
			output.append("Stack 3, size " + this.sizeThird + ": ");
			for (int ii = 0; ii < this.sizeThird; ii++) {
				output.append(this.container[ii * 3 + 2]);
				output.append(" ");

			}
			output.append(".\n");
		} else {
			output.append("Stack 3 is empty.\n");
		}

		return output.toString();
	}

}

public class Question_03_01 {

	public static void main(String[] args) {
		TrippleStack stacks = new TrippleStack(3, 4, 5);
		
		stacks.push(StackIndex.SECOND, 2);
		stacks.push(StackIndex.THIRD, 6);
		stacks.push(StackIndex.SECOND, 8);
		stacks.push(StackIndex.FIRST, 10);
		stacks.push(StackIndex.FIRST, 12);
		stacks.push(StackIndex.SECOND, 4);
		stacks.push(StackIndex.SECOND, 6);
		stacks.push(StackIndex.THIRD, 3);
		stacks.push(StackIndex.THIRD, 9);
		
		System.out.println(stacks);
		
		System.out.println(stacks.pop(StackIndex.FIRST));
		System.out.println(stacks.pop(StackIndex.FIRST));
		System.out.println(stacks.pop(StackIndex.SECOND));
		System.out.println(stacks.pop(StackIndex.SECOND));
		System.out.println(stacks.pop(StackIndex.SECOND));
		System.out.println(stacks.pop(StackIndex.SECOND));
		System.out.println(stacks.pop(StackIndex.THIRD));
		System.out.println(stacks.pop(StackIndex.THIRD));
		System.out.println(stacks.pop(StackIndex.THIRD));
		

	}

}
