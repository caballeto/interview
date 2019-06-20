package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;
import leetcode.Printer;

public class _2_2_kthLast {
  // assume k < n = len(list)
  public static ListNode kthLast(ListNode head, int k) {
    if (head == null) return null;
    ListNode p1 = head, p2 = head;
    for (int i = 0; i < k; i++) p2 = p2.next;
    while (p2 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }

    return p1;
  }

  public static void main(String[] args) {
    // 1 -> 5 -> 5 -> 8 -> 1
    ListNode head = new ListNode(1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(1);

    Printer.print(kthLast(head, 3)); // 5 -> 8 -> 1
  }
}
