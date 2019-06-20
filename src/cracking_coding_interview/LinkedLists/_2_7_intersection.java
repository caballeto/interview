package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;

public class _2_7_intersection {
  private static int len(ListNode node) {
    int count = 0;
    while (node != null) {
      count++;
      node = node.next;
    }

    return count;
  }

  public ListNode intersection(ListNode a, ListNode b) {
    int l1 = len(a), l2 = len(b);
    if (l1 > l2) {
      int diff = l1 - l2;
      for (int i = 0; i < diff; i++) a = a.next;
    } else {
      int diff = l2 - l1;
      for (int i = 0; i < diff; i++) b = b.next;
    }

    while (a != null && b != null) {
      if (a == b) return a;
      a = a.next;
      b = b.next;
    }

    return null;
  }
}
