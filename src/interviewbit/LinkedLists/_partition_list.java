package interviewbit.LinkedLists;

public class _partition_list {
  static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
  }

  public static ListNode partition(ListNode node, int value) {
    if (node == null) return null;
    ListNode firstSmall = new ListNode(0), firstBig = new ListNode(0);
    ListNode small = firstSmall, big = firstBig;

    while (node != null) {

      if (node.val < value) {
        small.next = node;
        small = node;
      } else {
        big.next = node;
        big = node;
      }

      node = node.next;
    }

    big.next = null;
    small.next = null;
    small.next = firstBig.next;

    return firstSmall.next;
  }
}
