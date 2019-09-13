package google;

public class _knapsack {
  static int knapsack(int[] values, int[] weight, int W) {
    int n = values.length;
    if (W == 0 || n == 0) return 0;
    int[][] dp = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {
      for (int w = 1; w <= W; w++) {
        dp[i][w] = dp[i - 1][w];
        if (w - weight[i - 1] >= 0) {
          dp[i][w] = Math.max(dp[i][w], values[i - 1] + dp[i - 1][w - weight[i - 1]]);
        }
      }
    }

    return dp[n][W];
  }

  public static void main(String[] args) {
    System.out.println(knapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
  }
}
