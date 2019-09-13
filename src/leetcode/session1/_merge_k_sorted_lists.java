package leetcode.session1;

import leetcode.ListNode;

public class _merge_k_sorted_lists {
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    if (lists.length == 1) return lists[0];

    int step = 1;
    while (step < lists.length) {
      for (int i = 0; i < lists.length - step; i += 2*step)
        lists[i] = mergeTwoLists(lists[i], lists[i + step]);
      step *= 2;
    }

    return lists[0];
  }

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
