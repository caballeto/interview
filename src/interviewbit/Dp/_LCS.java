package interviewbit.Dp;

public class _LCS {
  public static int longestCommonSeq(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSeq("AGGTAB", "GXTXAYB"));
  }
}
