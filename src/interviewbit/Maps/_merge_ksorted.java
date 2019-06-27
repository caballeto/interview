package interviewbit.Maps;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _merge_ksorted {
  public ListNode mergeKLists(ArrayList<ListNode> list) {
    if (list.isEmpty()) return null;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());

    for (ListNode node : list) {
      while (node != null) {
        pq.add(node.val);
        node = node.next;
      }
    }

    ListNode node = new ListNode(pq.poll()), head = node;
    while (!pq.isEmpty()) {
      node.next = new ListNode(pq.poll());
      node = node.next;
    }

    return head;
  }
}
