package leetcode;

public class _416_sum_partition {
  public boolean canPartition(int[] nums) {
    int[] dp = new int[nums.length + 1];
    int S = 0;
    for (int num : nums) S += num;
    for (int i = 1; i <= nums.length; i++) {
      int sum = S;
      dp[i] = dp[i - 1] + nums[i - 1];
      sum -= nums[i - 1];
      for (int j = i + 1; j <= nums.length; j++) {
        if (dp[j - 1] + nums[j - 1] <= sum - nums[j - 1]) {
          dp[j] = dp[j - 1] + nums[j - 1];
          sum -= nums[j - 1];
        } else dp[j] = dp[j - 1];
      }

      if (sum == dp[nums.length]) return true;
      else dp[i] = dp[i - 1];
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
    System.out.println(new _416_sum_partition().canPartition(nums));
  }
}
