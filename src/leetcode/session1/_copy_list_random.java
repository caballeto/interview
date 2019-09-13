package leetcode.session1;

import java.util.HashMap;
import java.util.Map;

public class _copy_list_random {
  static class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }

  public static Node copyRandomList(Node head) {
    if (head == null) return null;
    Map<Node, Integer> nodes = new HashMap<>();
    Map<Integer, Node> indices = new HashMap<>();
    Node first = new Node(), node = first, curr = head;
    int i = 0;
    while (curr != null) {
      node.next = new Node(curr.val, null, null);
      nodes.put(curr, i);
      indices.put(i, node.next);
      i++;
      node = node.next;
      curr = curr.next;
    }

    curr = head;
    node = first.next;

    while (curr != null) {
      if (curr.random != null) {
        int index = nodes.get(curr.random);
        node.random = indices.get(index);
      }

      curr = curr.next;
      node = node.next;
    }

    return first.next;
  }

  public static void main(String[] args) {
    Node node = new Node();
    node.val = 1;
    node.next = new Node();
    node.next.val = 2;
    node.random = node.next;
    node.next.random = node.next;
    copyRandomList(node);
  }
}
