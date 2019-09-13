package leetcode.session1;

import java.util.Arrays;

public class _min_moves {
  public int minMoves2(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    Arrays.sort(nums);
    int median = nums[nums.length / 2];
    int moves = 0;
    for (int val : nums)
      moves += Math.abs(val - median);
    return moves;
  }
}
