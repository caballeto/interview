package google;

public class _cut_rod {
  static int cutRodSlow(int[] price, int n) {
    if (n <= 0) return 0;
    if (price == null || price.length == 0) return 0;
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j - i >= 0)
          dp[i][j] = Math.max(dp[i][j], dp[i][j - i] + price[i - 1]);
      }
    }

    return dp[n][n];
  }

  static int cutRod(int[] price, int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++)
        max = Math.max(max, dp[i - j - 1] + price[j]);
      dp[i] = max;
    }

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(cutRod(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8));
  }
}
