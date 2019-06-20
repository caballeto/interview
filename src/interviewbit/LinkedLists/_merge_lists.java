package interviewbit.LinkedLists;

public class _merge_lists {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  public static ListNode mergeTwoLists(ListNode a, ListNode b) {
    ListNode head = new ListNode(0), current = head;

    while (a != null || b != null) {
      if (a == null) {
        current.next = new ListNode(b.val);
        b = b.next;
      } else if (b == null) {
        current.next = new ListNode(a.val);
        a = a.next;
      } else {
        if (a.val > b.val) {
          current.next = new ListNode(b.val);
          b = b.next;
        } else {
          current.next = new ListNode(a.val);
          a = a.next;
        }
      }

      current = current.next;
    }

    return head.next;
  }
}
