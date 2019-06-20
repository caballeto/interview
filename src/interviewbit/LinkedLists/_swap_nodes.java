package interviewbit.LinkedLists;

public class _swap_nodes {
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

  public ListNode swapPairs(ListNode node) {
    if (node == null) return null;
    int len = len(node);
    len = len % 2 == 0 ? len : len - 1;
    if (len == 0) return node;
    ListNode current = node, next = node.next, head = next;

    for (int i = 0; i < len / 2; i++) {
      if (i == len/2 - 1) {
        ListNode last = next.next;
        next.next = current;
        current.next = last;
      } else {
        ListNode temp = next.next;
        next.next = current;
        current.next = temp.next;
        current = temp;
        next = temp.next;
      }
    }

    return head;
  }
}
