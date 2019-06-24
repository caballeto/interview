package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class _copy_list {
  static class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { label = x; }
  }

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) return null;
    HashMap<RandomListNode, Integer> index = new HashMap<>();
    RandomListNode curr = head;
    int i = 0;
    while (curr != null) {
      index.put(curr, i++);
      curr = curr.next;
    }

    ArrayList<Integer> randoms = new ArrayList<>();
    curr = head;
    while (curr != null) {
      randoms.add(curr.random == null ? -1 : index.get(curr.random));
      curr = curr.next;
    }

    HashMap<Integer, RandomListNode> nodes = new HashMap<>();
    RandomListNode dummy = new RandomListNode(0), current = dummy;
    curr = head;
    i = 0;
    while (curr != null) {
      current.next = new RandomListNode(curr.label);
      nodes.put(i++, current.next);
      current = current.next;
      curr = curr.next;
    }

    curr = dummy.next;
    i = 0;
    while (curr != null) {
      int val = randoms.get(i++);
      curr.random = val == -1 ? null : nodes.get(val);
      curr = curr.next;
    }

    return dummy.next;
  }
}
