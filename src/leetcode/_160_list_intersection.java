package leetcode;

import java.util.HashSet;

public class _160_list_intersection {
  public ListNode getIntersectionNode(ListNode a, ListNode b) {
    if (a == null || b == null) return null;
    HashSet<ListNode> set = new HashSet<>();

    ListNode current = a;

    while (current != null) {
      set.add(current);
      current = current.next;
    }

    current = b;

    while (current != null) {
      if (set.contains(current)) {
        return current;
      }

      current = current.next;
    }

    return null;
  }
}
