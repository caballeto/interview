package leetcode.session1;

public class _can_jump {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) return false;
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++)
      if (i <= max)
        max = Math.max(max, i + nums[i]);
    return max >= nums.length - 1;
  }
}
