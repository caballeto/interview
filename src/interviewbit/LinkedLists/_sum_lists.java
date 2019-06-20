package interviewbit.LinkedLists;

public class _sum_lists {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  public static ListNode addTwoNumbers(ListNode a, ListNode b) {
    ListNode result = new ListNode(0), curr = result;
    int carry = 0;

    while (a != null || b != null) {
      if (a == null) {
        int s = b.val + carry;
        curr.next = new ListNode(s >= 10 ? s - 10 : s);
        carry = s >= 10 ? 1 : 0;
        b = b.next;
      } else if (b == null) {
        int s = a.val + carry;
        curr.next = new ListNode(s >= 10 ? s - 10 : s);
        carry = s >= 10 ? 1 : 0;
        a = a.next;
      } else {
        int s = a.val + b.val + carry;
        carry = s >= 10 ? 1 : 0;
        curr.next = new ListNode(s >= 10 ? s - 10 : s);
        a = a.next;
        b = b.next;
      }

      curr = curr.next;
    }

    if (carry == 1)
      curr.next = new ListNode(1);

    return result.next;
  }
}
