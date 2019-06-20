package leetcode;

public class _72_edit_distance {
  public int minDistance(String a, String b) {
    if (a.isEmpty()) return b.length();
    if (b.isEmpty()) return a.length();
    int n = a.length(), m = b.length();
    int[][] dp = new int[n + 1][m + 1];

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
    String a = "", b = "abbb";
    System.out.println(new _72_edit_distance().minDistance(a, b));
  }
}
