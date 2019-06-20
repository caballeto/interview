package interviewbit.LinkedLists;

public class _remove_nth {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  private static int len(ListNode node) {
    int count = 0;

    while (node != null) {
      node = node.next;
      count++;
    }

    return count;
  }

  public static ListNode removeNthFromEnd(ListNode node, int n) {
    int len = len(node);

    if (n >= len)
      return node.next;
    if (n < 1)
      throw new IllegalArgumentException();

    ListNode first = node, k = node;

    for (int i = 0; i < n; i++)
      k = k.next;

    while (k.next != null) {
      first = first.next;
      k = k.next;
    }

    first.next = first.next.next;
    return node;
  }
}