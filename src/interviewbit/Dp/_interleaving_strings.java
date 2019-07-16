package interviewbit.Dp;

public class _interleaving_strings {
  public static int isInterleave(String s1, String s2, String s) {
    if (s1.length() + s2.length() != s.length()) return 0;
    int n = s1.length(), m = s2.length();
    boolean[][] dp = new boolean[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 && j == 0)
          dp[i][j] = true;
        else if (i == 0 && s2.charAt(j - 1) == s.charAt(j - 1))
          dp[i][j] = dp[i][j - 1];
        else if (j == 0 && s1.charAt(i - 1) == s.charAt(i - 1))
          dp[i][j] = dp[i - 1][j];
        else if (i == 0 || j == 0)
          continue;
        else if (s1.charAt(i - 1) == s.charAt(i + j - 1) && s2.charAt(j - 1) != s.charAt(i + j - 1))
          dp[i][j] = dp[i - 1][j];
        else if (s1.charAt(i - 1) != s.charAt(i + j - 1) && s2.charAt(j - 1) == s.charAt(i + j - 1))
          dp[i][j] = dp[i][j - 1];
        else if (s1.charAt(i - 1) == s.charAt(i + j - 1) && s2.charAt(j - 1) == s.charAt(i + j - 1))
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
      }
    }

    return dp[n][m] ? 1 : 0;
  }

  public static void main(String[] args) {
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
}
