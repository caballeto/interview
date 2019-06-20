package leetcode;

public class _206_reverse_llist {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    ListNode next = head.next;
    head.next = null;
    while (next != null) {
      ListNode temp = next.next;
      next.next = head;
      head = next;
      next = temp;
    }

    return head;
  }
}
