package google;

public class _lcs {
  private static int LCS(String a, String b) {
    if (a.isEmpty() || b.isEmpty()) return 0;
    int n = a.length(), m = b.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    System.out.println(LCS("ABCDGH", "AEDFHR") == 3);
    System.out.println(LCS("AGGTAB", "GXTXAYB") == 4);
  }
}
