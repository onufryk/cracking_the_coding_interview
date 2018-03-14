package com.onufryk.crack;

import com.onufryk.crack.common.LinkedList;
import com.onufryk.crack.common.Node;



class NthSearchableList extends LinkedList {
  public NthSearchableList() {
    super();
  }
  public  NthSearchableList(Node root) {
    super(root);
  }

  public Integer nthFromTail(Integer n) {
    if (n == null || n.equals(0)) {
      return null;
    }
    Node current = this.root;

    for (int i = 0; i < n; i++) {
      if (current == null) {
        return null;
      }
      current = current.next;
    }

    Node follower = this.root;
    while (current != null) {
      current = current.next;
      follower = follower.next;
    }
    return follower.value;
  }
}



public class Question_02_02 {
	public static void main(String[] args) {
    NthSearchableList list = new NthSearchableList(new Node (5, new Node (6, new Node(2, new Node(6, new Node(3, new Node(8, new Node(2, new Node(5, new Node(5))))))))));
    System.out.println(list);
    System.out.println(list.nthFromTail(5));
  }
}
