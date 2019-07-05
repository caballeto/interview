package interviewbit.Dp;

public class _edit_distance {
  public static int minDistance(String a, String b) {
    int n = a.length(), m = b.length();
    if (n == 0) return m;
    if (m == 0) return n;
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++)
      dp[i][0] = i;
    for (int j = 1; j <= m; j++)
      dp[0][j] = j;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    System.out.println(minDistance("b", "a"));
  }
}
