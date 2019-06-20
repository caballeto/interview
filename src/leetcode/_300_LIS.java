package leetcode;

public class _300_LIS {
  public int lengthOfLIS(int[] nums) {
    int maxTotal = 1;
    int[] dp = new int[nums.length];
    dp[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] > nums[j] && dp[j] > max) {
          max = dp[j];
        }
      }

      dp[i] = max + 1;
      maxTotal = Math.max(maxTotal, dp[i]);
    }

    return maxTotal;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {10,9,2,5,3,7,101,18};
    System.out.println(new _300_LIS().lengthOfLIS(nums));
  }
}
