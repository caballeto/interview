package interviewbit.LinkedLists;

public class _palindrom_list {
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

  public static int lPalin(ListNode node) {
    if (node == null) return 1;
    int len = len(node), offset = len / 2;
    ListNode first = node, second = node;

    for (int i = 0; i < offset; i++)
      second = second.next;

    ListNode temp = second;
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
      if (first.val != second.val)
        return 0;
      first = first.next;
      second = second.next;
      count++;
    }

    return 1;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(1);
    System.out.println(lPalin(a));
  }
}
