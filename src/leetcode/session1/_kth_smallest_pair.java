package leetcode.session1;

import java.util.*;

public class _kth_smallest_pair {
  // 1, 7, 11
  // 2, 4, 6
  //
  static int[][] moves = {{1, 0}, {0, 1}};

  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums1.length, m = nums2.length;
    if (n == 0 || m == 0) return result;
    boolean[][] marked = new boolean[n][m];
    Queue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.value));
    q.add(new Pair(0, 0, nums1[0] + nums2[0]));
    while (k > 0 && !q.isEmpty()) {
      Pair min = q.poll();
      result.add(Arrays.asList(nums1[min.row], nums2[min.col]));
      k--;
      for (int[] move : moves) {
        int row = min.row + move[0];
        int col = min.col + move[1];
        if (row < 0 || row >= n || col < 0 || col >= m || marked[row][col]) continue;
        marked[row][col] = true;
        q.add(new Pair(row, col, nums1[row] + nums2[col]));
      }
    }

    return result;
  }

  static class Pair {
    int row;
    int col;
    int value;

    Pair(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
  }
}
