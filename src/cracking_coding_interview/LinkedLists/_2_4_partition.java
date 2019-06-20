package cracking_coding_interview.LinkedLists;

public class _2_4_partition {
  public static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.println("" + node);
  }

  private static class ListNode {
    ListNode next, prev;
    int val;
    ListNode(int d) { val = d; }
  }

  public static void partition(ListNode head, int part) {
    ListNode p1 = head, p2 = head;
    while (p2.next != null) p2 = p2.next;
    while (p1 != p2) {
      if (p1.val < part) p1 = p1.next;
      else {
        int temp = p2.val;
        p2.val = p1.val;
        p1.val = temp;
        p2 = p2.prev;
      }
    }
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(3);
    node.next = new ListNode(5);
    node.next.prev = node;
    node.next.next = new ListNode(8);
    node.next.next.prev = node.next;
    node.next.next.next = new ListNode(5);
    node.next.next.next.prev = node.next.next;
    node.next.next.next.next = new ListNode(10);
    node.next.next.next.next.prev = node.next.next.next;
    node.next.next.next.next.next = new ListNode(2);
    node.next.next.next.next.next.prev = node.next.next.next.next;

    print(node);
    partition(node, 5);
    print(node);
  }
}
