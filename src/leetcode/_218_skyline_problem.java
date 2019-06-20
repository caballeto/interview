package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _218_skyline_problem {
  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> skyline = new ArrayList<>();
    List<int[]> heights = new ArrayList<>();

    for (int[] building : buildings) {
      heights.add(new int[]{building[0], -building[2]});
      heights.add(new int[]{building[1], building[2]});
    }

    heights.sort((a, b) -> {
      if (a[0] != b[0])
        return a[0] - b[0];
      return a[1] - b[1];
    });

    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // max heap
    pq.offer(0);
    int prev = 0;
    for (int[] h : heights) {
      if (h[1] < 0) {
        pq.offer(-h[1]);
      } else {
        pq.remove(h[1]);
      }

      int val = pq.peek();
      if (prev != val) {
        skyline.add(new int[]{h[0], val});
        prev = val;
      }
    }

    return skyline;
  }
}
