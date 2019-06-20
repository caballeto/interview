package interviewbit.LinkedLists;

public class _reorder_list {
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

  public static ListNode reorderList(ListNode node) {
    if (node == null) return null;
    int len = len(node), offset = len / 2;
    ListNode first = node, second = node, temp;

    for (int i = 0; i < offset; i++)
      second = second.next;

    temp = second;
    second = second.next;

    while (second != null) {
      ListNode n = second.next;
      second.next = temp;
      temp = second;
      second = n;
    }

    second = temp;
    int count = (len % 2 == 0) ? 1 : 0;
    while (count <= offset) {
      if (first == second) {
        first.next = null;
        break;
      }
      if (count == offset) {
        second.next = null; // Does not produce NullPointerException()
        first.next = second;
      } else {
        ListNode n = second.next;
        second.next = first.next;
        first.next = second;
        first = second.next;
        second = n;
      }

      count++;
    }

    return node;
  }
}
