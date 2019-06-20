package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;
import leetcode.Printer;

import java.util.HashMap;

public class _2_1_removeDups {
  public static void removeDups(ListNode head) {
    if (head == null) return;
    ListNode curr = head;
    HashMap<Integer, Integer> map = new HashMap<>();
    while (curr != null) {
      if (map.containsKey(curr.val))
        map.put(curr.val, map.get(curr.val) + 1);
      else map.put(curr.val, 1);
      curr = curr.next;
    }

    curr = head;
    while (curr.next != null) {
      int count = map.get(curr.next.val);
      if (count > 1) {
        map.put(curr.next.val, count - 1);
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
  }

  public static void main(String[] args) {
    // 1 -> 5 -> 5 -> 8 -> 1
    ListNode head = new ListNode(1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(1);

    removeDups(head);
    Printer.print(head);
  }
}
