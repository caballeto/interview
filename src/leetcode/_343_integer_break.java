package leetcode;

public class _343_integer_break {
  public int integerBreak(int n) {
    if (n <= 0) return 0;
    if (n <= 2) return 1;
    if (n == 3) return 2;

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int j = 4; j <= n; j++) {
      int p = Integer.MIN_VALUE;
      for (int i = 1; i < j; i++)
        if (p < dp[i] * dp[j - i])
          p = dp[i] * dp[j - i];
      dp[j] = p;
    }

    return dp[n];
  }
}
