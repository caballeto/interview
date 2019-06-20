package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class _23_merge_ksorted_lists {
  public ListNode mergeKLists(ListNode[] lists) {
    ArrayList<Integer> vals = new ArrayList<>();

    for (ListNode node : lists) {
      while (node != null) {
        vals.add(node.val);
        node = node.next;
      }
    }

    if (vals.size() == 0) return null;
    Collections.sort(vals);

    ListNode node = new ListNode(0), head = node;
    for (int i = 0; i < vals.size(); i++) {
      if (i == 0) {
        node.val = vals.get(i);
        continue;
      }

      node.next = new ListNode(vals.get(i));
      node = node.next;
    }

    return head;
  }
}
