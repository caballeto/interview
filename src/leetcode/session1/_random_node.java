package leetcode.session1;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _random_node {
  class Solution {
    private Random random = new Random();
    private List<Integer> list = new ArrayList<>();

    public Solution(ListNode head) {
      ListNode curr = head;
      while (curr != null) {
        list.add(curr.val);
        curr = curr.next;
      }
    }

    /** Returns a random node's value. */
    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
  }

  class SpaceOptSolution {
    private Random random = new Random();
    private int size;
    private ListNode head;

    public SpaceOptSolution(ListNode head) {
      this.head = head;
      this.size = 0;
      while (head != null) {
        size++;
        head = head.next;
      }
    }

    /** Returns a random node's value. */
    public int getRandom() {
      int index = random.nextInt(size);
      ListNode curr = head;
      while (index > 0) {
        curr = curr.next;
        index--;
      }

      return curr.val;
    }
  }
}
