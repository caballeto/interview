package leetcode;

public class _203_remove_llist {
  public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) head = head.next;
    if (head == null) return null;
    ListNode prev = head, current = head.next;
    while (current != null) {
      if (current.val == val) {
        prev.next = current.next;
        current = current.next;
      } else {
        prev = prev.next;
        current = current.next;
      }
    }

    return head;
  }
}
