package com.onufryk.crack.two;

import com.onufryk.crack.common.IntLinkedList;
import com.onufryk.crack.common.IntNode;



class NthSearchableList extends IntLinkedList {
  public NthSearchableList() {
    super();
  }
  public  NthSearchableList(IntNode root) {
    super(root);
  }

  public Integer nthFromTail(Integer n) {
    if (n == null || n.equals(0)) {
      return null;
    }
    IntNode current = this.root;

    for (int i = 0; i < n; i++) {
      if (current == null) {
        return null;
      }
      current = current.next;
    }

    IntNode follower = this.root;
    while (current != null) {
      current = current.next;
      follower = follower.next;
    }
    return follower.value;
  }
}



public class Question_02_02 {
	public static void main(String[] args) {
    NthSearchableList list = new NthSearchableList(new IntNode (5, new IntNode (6, new IntNode(2, new IntNode(6, new IntNode(3, new IntNode(8, new IntNode(2, new IntNode(5, new IntNode(5))))))))));
    System.out.println(list);
    System.out.println(list.nthFromTail(5));
  }
}
