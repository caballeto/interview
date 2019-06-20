package interviewbit.LinkedLists;

public class _reverse_between {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  private static int len(ListNode node) {
    int count = 0;

    while (node != null) {
      count++;
      node = node.next;
    }

    return count;
  }

  private static ListNode move(ListNode node, int x) {
    int len = len(node);
    if (x <= 0 || x > len) return null;
    ListNode n = node;
    for (int i = 1; i < x; i++)
      n = n.next;
    return n;
  }

  public static ListNode reverseBetween(ListNode node, int m, int n) {
    ListNode first = move(node, m - 1), last = move(node, n + 1);
    ListNode current, prev = first, next;
    boolean flag = false;
    if (first == null) {
      flag = true;
      first = new ListNode(0);
      first.next = node;
    }

    current = first.next;

    while (current != last) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    first.next.next = last;
    first.next = prev;

    return flag ? first.next : node;
  }
}
