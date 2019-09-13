package google;

import java.util.Arrays;

public class _game_strategy {
  static int[][] dp;

  static int optStrategy(int[] game) {
    int n = game.length;
    if (n == 0) return 0;
    if (n == 2) return Math.max(game[0], game[1]);
    dp = new int[n][n];
    for (int[] row : dp)
      Arrays.fill(row, - 1);
    for (int i = 0; i < n; i++)
      dp[i][i] = game[i];

    //return dp[0][n - 1] = solve(game, 0, n - 1, 0);
    return -1;
  }

  private static int sum(int[] array) {
    int sum = 0;
    for (int val : array)
      sum += val;
    return sum;
  }

  private static int solve(int[] game, int lo, int hi, int val, int sum) {
    if (dp[lo][hi] != -1) return dp[lo][hi];
    sum -= val;
    int left = solve(game, lo + 1, hi, game[lo], sum);
    int right = solve(game, lo, hi - 1, game[hi], sum);
    dp[lo][hi] = Math.max(left, right);
    return val + sum - dp[lo][hi];
  }

  public static void main(String[] args) {
    System.out.println(optStrategy(new int[]{5, 3, 7, 10}) == 15);
    System.out.println(optStrategy(new int[]{8, 15, 3, 7}) == 22);
  }
}
