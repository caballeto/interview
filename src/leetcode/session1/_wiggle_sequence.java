package leetcode.session1;

import java.util.Arrays;

public class _wiggle_sequence {
  public static int wiggleMaxLength(int[] nums) {
    if (nums.length < 2)
      return nums.length;
    int down = 1, up = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1])
        up = down + 1;
      else if (nums[i] < nums[i - 1])
        down = up + 1;
    }

    return 1 + Math.max(down, up);
  }

  public static void main(String[] args) {
    System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
  }
}
