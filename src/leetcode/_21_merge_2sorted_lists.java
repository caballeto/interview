package leetcode;

public class _21_merge_2sorted_lists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;

    ListNode node, head;
    if (l1 == null) {
      head = node = new ListNode(l2.val);
      l2 = l2.next;
    } else if (l2 == null) {
      head = node = new ListNode(l1.val);
      l1 = l1.next;
    } else if (l1.val < l2.val) {
      head = node = new ListNode(l1.val);
      l1 = l1.next;
    } else {
      head = node = new ListNode(l2.val);
      l2 = l2.next;
    }

    while (l1 != null || l2 != null) {
      if (l1 == null) {
        node.next = new ListNode(l2.val);
        l2 = l2.next;
        node = node.next;
      } else if (l2 == null) {
        node.next = new ListNode(l1.val);
        l1 = l1.next;
        node = node.next;
      } else {
        if (l1.val < l2.val) {
          node.next = new ListNode(l1.val);
          l1 = l1.next;
          node = node.next;
        } else {
          node.next = new ListNode(l2.val);
          l2 = l2.next;
          node = node.next;
        }
      }
    }

    return head;
  }
}
