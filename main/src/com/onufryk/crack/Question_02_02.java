class Node {
  Integer value = null;
  Node next = null;

  public Node(Integer value) {
    this.value = value;
    this.next = null;
  }
  public Node(Integer value, Node next) {
    this.value = value;
    this.next = next;
  }
}

class LinkedList {
  Node root = null;

  public LinkedList() {
  }

  public LinkedList(Node root) {
    this.root = root;
  }

  public String toString() {
    StringBuffer output = new StringBuffer();
    Node current = this.root;
    while (current != null) {
      output.append(current.value);
      current = current.next;
    }

    return output.toString();
  }
}

class SpecificList extends LinkedList {
  public SpecificList() {
    super();
  }
  public  SpecificList(Node root) {
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
    SpecificList list = new SpecificList(new Node (5, new Node (6, new Node(2, new Node(6, new Node(3, new Node(8, new Node(2, new Node(5, new Node(5))))))))));
    System.out.println(list);
    System.out.println(list.nthFromTail(5));
  }
}
