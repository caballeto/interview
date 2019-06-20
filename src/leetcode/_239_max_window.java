package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _239_max_window {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) return new int[]{};
    int[] max = new int[nums.length - k + 1];
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

    for (int i = 0; i < k; i++) {
      pq.offer(nums[i]);
    }

    int j = 0;
    max[j++] = pq.peek();
    for (int i = k; i < nums.length; i++) {
      pq.remove(nums[i - k]);
      pq.offer(nums[i]);
      max[j++] = pq.peek();
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    System.out.println(Arrays.toString(new _239_max_window().maxSlidingWindow(nums, k)));
  }
}
