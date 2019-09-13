package leetcode.session1;

import java.util.*;

public class _random_index {
  class Solution {
    private Random random = new Random();
    private int[] nums;

    public Solution(int[] nums) {
      this.nums = nums;
    }

    public int pick(int target) {
      int index = -1;
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target && random.nextInt(count++) == 0) {
          index = i;
        }
      }

      return index;
    }
  }
}
