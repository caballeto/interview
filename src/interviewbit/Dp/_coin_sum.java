package interviewbit.Dp;

public class _coin_sum {
  public static int coinchange2n(int[] coins, int n) {
    long[] dp = new long[n + 1];
    dp[0] = 1;

    for (int i = 0; i < coins.length; i++)
      for (int j = coins[i]; j <= n; j++)
        dp[j] += dp[j - coins[i]] % 1000007;

    return (int) (dp[n] % 1000007);
  }

  public static int coinchange2(int[] coins, int n) {
    int m = coins.length;
    int[][] dp = new int[n + 1][m];

    for (int i = 0; i < m; i++)
      dp[0][i] = 1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = 0; j < m; j++) {
        int x = (i - coins[j] >= 0) ? dp[i - coins[j]][j] : 0;
        int y = (j >= 1) ? dp[i][j - 1] : 0;
        dp[i][j] = x + y;
      }
    }

    return dp[n][m - 1];
  }

  // recursive
  private static int solve(int[] coins, int m, int n) {
    if (n == 0 && m >= 0) return 1;
    if (n > 0 && m == 0) return 0;
    if (n < 0) return 0;
    int left = solve(coins, m, n - coins[m - 1]);
    int right = solve(coins, m - 1, n);
    return left + right;
  }

  public static void main(String[] args) {
    System.out.println(coinchange2n(new int[]{18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 }, 458));
  }
}
