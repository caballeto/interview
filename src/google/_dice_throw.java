package google;

public class _dice_throw {
  static int throwDice(int n, int m, int sum) {
    if (n == 0) return 0;
    int[][] dp = new int[n + 1][sum + 1];

    for (int i = 1; i <= m && i <= sum; i++)
      dp[1][i] = 1;

    for (int i = 2; i <= n; i++)
      for (int j = 1; j <= sum; j++)
        for (int k = 1; k <= m && k < j; k++)
          dp[i][j] += dp[i - 1][j - k];

    return dp[n][sum];
  }

  public static void main(String[] args) {
    System.out.println(throwDice(6, 3, 8) == 21);
  }
}
