package cracking_coding_interview.Recursion;

public class _8_11_coins {
  public static int ways(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] = 1;
      if (i >= 5)  dp[i] += dp[i - 5];
      if (i >= 10) dp[i] += dp[i - 10];
      if (i >= 25) dp[i] += dp[i - 25];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(ways(10));
  }
}
