package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368_LDS {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int index = 0;
    for (int i = 1; i < nums.length; i++) {
      index = dp[i] > dp[index] ? i : index;
    }

    int temp = nums[index];
    int size = dp[index];
    for (int i = index; i >= 0; i--) {
      if (temp % nums[i] == 0 && dp[i] == size) {
        result.add(nums[i]);
        temp = nums[i];
        size--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1};
    System.out.println(new _368_LDS().largestDivisibleSubset(nums));
  }
}
