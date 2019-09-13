package leetcode.session1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _connect_ropes {
  public static int minimumCost(int[] ropes) {
    if (ropes == null || ropes.length <= 1) return 0;
    Queue<Integer> pq = new PriorityQueue<>();
    for (int rope : ropes) {
      pq.add(rope);
    }

    int cost = 0;
    while (pq.size() > 1) {
      int currentCost = pq.poll() + pq.poll();
      cost += currentCost;
      pq.add(currentCost);
    }

    return cost;
  }

  public static void main(String[] args) {
    System.out.println(minimumCost(new int[]{8, 4, 6, 12}) == 58);
    System.out.println(minimumCost(new int[]{20, 4, 8, 2}) == 54);
    System.out.println(minimumCost(new int[]{1, 2, 5, 10, 35, 89}) == 224);
    System.out.println(minimumCost(new int[]{2, 2, 3, 3}) == 20);
  }
}
