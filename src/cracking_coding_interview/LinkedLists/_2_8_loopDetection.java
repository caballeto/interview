package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;

public class _2_8_loopDetection {
  public static ListNode detect(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) break;
    }

    if (fast == null || fast.next == null) return null;

    slow = head;
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}
