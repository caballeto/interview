package interviewbit.LinkedLists;

public class _detect_cycle {
  class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
  }

  public ListNode detectCycle(ListNode a) {
    if (a == null) return null;

    ListNode slow = a, fast = a;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    if (fast == null || fast.next == null) return null;

    slow = a;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}
