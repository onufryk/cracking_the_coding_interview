package com.onufryk.crack;

import com.onufryk.crack.common.LinkedList;

public class Question_02_01 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList().a(5).a(5).a(6).a(2).a(6).a(3).a(2).a(5).a(5);
		
		System.out.println(list);

		list.dedupe();

		System.out.println(list);
	}

}
