package leetcode;

import java.util.Arrays;

public class _338_counting_bits {
  public int[] countBits(int num) {
    int[] dp = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      dp[i] = 1 + dp[i & (i - 1)];
    }

    return dp;
  }

  public static void main(String[] args) {
    int num = 5;
    System.out.println(Arrays.toString(new _338_counting_bits().countBits(num)));
  }
}
