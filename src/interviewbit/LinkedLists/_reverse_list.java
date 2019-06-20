package interviewbit.LinkedLists;

public class _reverse_list {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  public static ListNode reverseList(ListNode node) {
    ListNode current, prev = null, next;
    current = node;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    node = prev;
    return node;
  }
}
