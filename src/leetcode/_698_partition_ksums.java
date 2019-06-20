package leetcode;

import java.util.Arrays;

public class _698_partition_ksums {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int sum = Arrays.stream(nums).sum();
    int target = sum / k;
    if (sum % k > 0 || nums[n - 1] > target) return false;

    boolean[] dp = new boolean[1 << n];
    dp[0] = true;
    int[] total = new int[1 << n];

    for (int state = 0; state < (1 << n); state++) {
      if (!dp[state]) continue;
      for (int i = 0; i < n; i++) {
        int future = state | (1 << i);
        if (state != future && !dp[future]) {
          if (nums[i] <= target - (total[state] % target)) {
            dp[future] = true;
            total[future] = total[state] + nums[i];
          } else break;
        }
      }
    }

    return dp[(1 << n) - 1];
  }
}
