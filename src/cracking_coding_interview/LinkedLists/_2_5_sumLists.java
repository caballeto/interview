package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;
import leetcode.Printer;

public class _2_5_sumLists {
  private static int len(ListNode node) {
    int count = 0;
    while (node != null) {
      count++;
      node = node.next;
    }

    return count;
  }

  public static ListNode sumLists(ListNode a, ListNode b) {
    if (a == null && b == null) return null;
    if (a == null) return b;
    if (b == null) return a;
    int l1 = len(a), l2 = len(b);
    if (l1 > l2) {
      sum(a, b);
      return a;
    } else {
      sum(b, a);
      return b;
    }
  }

  private static void sum(ListNode a, ListNode b) {
    int carry = 0;
    ListNode prev = a;
    while (a != null && b != null) {
      a.val += b.val + carry;
      if (a.val > 9) {
        a.val -= 10;
        carry = 1;
      } else carry = 0;
      prev = a;
      a = a.next;
      b = b.next;
    }

    while (carry == 1) {
      ListNode x = prev.next;
      if (x == null) x = new ListNode(0);
      x.val += carry;
      prev.next = x;
      if (x.val < 10) break;
      x.val -= 10;
      prev = prev.next;
    }
  }

  public static void main(String[] args) {
    // 89 + 15
    ListNode a = new ListNode(5);
    ListNode b = new ListNode(5);

    ListNode res = sumLists(a, b);
    Printer.print(res);
  }
}
