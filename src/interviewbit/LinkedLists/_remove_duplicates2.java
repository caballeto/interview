package interviewbit.LinkedLists;

import leetcode.ListNode;

public class _remove_duplicates2 {
  public static ListNode deleteDuplicates(ListNode node) {
    if (node == null) return null;
    ListNode head = new ListNode(Integer.MAX_VALUE);
    ListNode prevSeqNode = head, prevNode = node;
    prevSeqNode.next = prevNode;
    node = node.next;

    while (node != null) {
      if (node.val == prevNode.val) {
        while (node != null && node.val == prevNode.val)
          node = node.next;
        prevSeqNode.next = node;
        prevNode = node;
        if (node != null)
          node = node.next;
      } else {
        prevSeqNode.next = prevNode;
        prevSeqNode = prevNode;
        prevNode = node;
        node = node.next;
      }
    }

    return head.next;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    System.out.println(deleteDuplicates(a));
  }
}
