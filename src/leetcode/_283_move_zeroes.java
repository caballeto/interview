package leetcode;

import java.util.Arrays;

public class _283_move_zeroes {
  public void moveZeroes(int[] nums) {
    int i, j = 0;
    while (true) {
      while (j < nums.length && nums[j] != 0) j++;
      i = j + 1;
      while (i < nums.length && nums[i] == 0) i++;
      if (i == nums.length || j == nums.length || nums[i] == 0) return;
      nums[j] = nums[i];
      nums[i] = 0;
    }
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    new _283_move_zeroes().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
