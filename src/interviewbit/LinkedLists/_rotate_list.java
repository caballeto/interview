package interviewbit.LinkedLists;

public class _rotate_list {
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

  public static ListNode rotateRight(ListNode node, int k) {
    int len = len(node);
    k %= len;

    if (k == 0 || len == 1) return node;

    int offset = len - k;

    ListNode prev = node, next = node.next;

    for (int i = 0; i < offset; i++) {
      prev = prev.next;
      next = next.next;
    }

    ListNode head = next;
    prev.next = null;

    while (next.next != null)
      next = next.next;

    next.next = node;
    return head;
  }

  public static void main(String[] args) {

  }
}
