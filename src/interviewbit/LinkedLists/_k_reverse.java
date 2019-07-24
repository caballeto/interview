package interviewbit.LinkedLists;

import leetcode.ListNode;

public class _k_reverse {
  public static ListNode reverseList(ListNode node, int k) {
    ListNode current = node, next = null, prev = null;
    int count = 0;

    while (count < k && current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    if (next != null) {
      node.next = reverseList(next, k);
    }

    return prev;
  }
}
