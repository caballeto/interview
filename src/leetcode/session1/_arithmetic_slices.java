package leetcode.session1;

public class _arithmetic_slices {
  public static int numberOfArithmeticSlices(int[] nums) {
    if (nums == null) throw new IllegalArgumentException();
    int[] dp = new int[nums.length];
    int sum = 0;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        dp[i] = dp[i - 1] + 1;
        sum += dp[i];
      }
    }

    return sum;
  }
}
