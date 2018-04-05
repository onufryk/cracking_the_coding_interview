package com.onufryk.crack.two;

import com.onufryk.crack.common.IntLinkedList;

/**
 * Write code to remove duplicates from an unsorted linked list. 
 */
public class Question_02_01 {

	public static void main(String[] args) {
		IntLinkedList list = new IntLinkedList().a(5).a(5).a(6).a(2).a(6).a(3).a(2).a(5).a(5);
		
		System.out.println(list);

		list.dedupe();

		System.out.println(list);
	}

}
