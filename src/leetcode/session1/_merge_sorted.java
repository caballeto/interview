package leetcode.session1;

public class _merge_sorted {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode n1 = l1, n2 = l2, head = new ListNode(0), current = head;

    while (n1 != null || n2 != null) {
      if (n1 == null) {
        current.next = n2;
        n2 = n2.next;
      } else if (n2 == null) {
        current.next = n1;
        n1 = n1.next;
      } else if (n1.val > n2.val) {
        current.next = n2;
        n2 = n2.next;
      } else {
        current.next = n1;
        n1 = n1.next;
      }

      current = current.next;
    }

    return head.next;
  }
}
