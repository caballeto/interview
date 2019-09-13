package leetcode.session1;

public class _flatten_list {
  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
      val = _val;
      prev = _prev;
      next = _next;
      child = _child;
    }
  }

  public static Node flatten(Node head) {
    if (head == null) return null;
    flattenList(head);
    return head;
  }

  private static Node flattenList(Node node) {
    while (true) {
      if (node.child != null) {
        Node lastChild = flattenList(node.child);
        lastChild.next = node.next;
        if (node.next != null)
          node.next.prev = lastChild;
        node.next = node.child;
        node.child.prev = node;
        node.child = null;
        node = lastChild;
      }
      if (node.next == null)
        return node;
      node = node.next;
    }
  }
}
