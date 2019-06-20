package interviewbit.LinkedLists;

import java.util.ArrayList;
import java.util.Comparator;

public class _sort_list {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  public static ListNode sortList(ListNode node) {
    ArrayList<Integer> list = new ArrayList<>();
    ListNode curr = node;
    while (curr != null) {
      list.add(curr.val);
      curr = curr.next;
    }

    list.sort(Comparator.naturalOrder());
    curr = node;
    for (int val : list) {
      curr.val = val;
      curr = curr.next;
    }

    return node;
  }

  public static ListNode mergeSortList(ListNode node) {
    if (node == null || node.next == null) return node;
    ListNode mid = getMid(node), next = mid.next;
    mid.next = null;
    ListNode left = mergeSortList(node), right = mergeSortList(next);
    return merge(left, right);
  }

  // TODO: Implement iterative merge function
  private static ListNode merge(ListNode a, ListNode b) {
    if (a == null) return b;
    if (b == null) return a;

    ListNode res;
    if (a.val <= b.val) {
      res = a;
      res.next = merge(a.next, b);
    } else {
      res = b;
      res.next = merge(a, b.next);
    }

    return res;
  }

  private static ListNode getMid(ListNode node) {
    if (node == null) return null;
    ListNode slow = node, fast = node.next;

    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
        slow = slow.next;
      }
    }

    return slow;
  }
}
