package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;

public class _2_3_delMiddle {
  public static void delMid(ListNode node) {
    if (node == null) return;
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
