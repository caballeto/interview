package interviewbit.LinkedLists;

import leetcode.ListNode;

import java.util.HashMap;

public class _insertion_sort {
  public static ListNode insertionSortList(ListNode node) {
    HashMap<Integer, ListNode> list = new HashMap<>();
    ListNode curr = node;
    int len = 0;
    while (curr != null) {
      list.put(len++, curr);
      curr = curr.next;
    }

    for (int j = 1; j < len; j++) {
      int k = j;
      while (k > 0 &&list.get(k).val < list.get(k - 1).val) {
        swap(list.get(k), list.get(k - 1));
        k--;
      }
    }

    return list.get(0);
  }

  private static void swap(ListNode a, ListNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(10);
    node.next = new ListNode(15);
    node.next.next = new ListNode(7);
    node.next.next.next = new ListNode(44);
    node.next.next.next.next = new ListNode(-4);
    ListNode head = insertionSortList(node);

    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
