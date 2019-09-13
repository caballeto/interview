package google;

public class _code_change {
  static int coinChange(int[] array, int m) {
    if (array == null || array.length == 0) return 0;
    int n = array.length;
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++)
      dp[i][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j - array[i - 1] >= 0) {
          dp[i][j] += dp[i][j - array[i - 1]];
        }
      }
    }

    return dp[n][m] == 0 ? -1 : dp[n][m];
  }

  public static void main(String[] args) {
    System.out.println(coinChange(new int[]{1, 2, 3}, 4) == 4);
    System.out.println(coinChange(new int[]{2, 5, 3, 6}, 10) == 5);
    System.out.println(coinChange(new int[]{1, 2, 5}, 11));
  }
}
