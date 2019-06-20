package leetcode;

public class _237_delete_node {
  public void deleteNode(ListNode node) {
    if (node == null || node.next == null) return;
    ListNode prev = node, curr = node.next;
    while (curr.next != null) {
      prev.val = curr.val;
      prev = prev.next;
      curr = curr.next;
    }
    prev.val = curr.val;
    prev.next = null;
  }
}
