package interviewbit.Dp;

public class _match_regexp {
  public static int isMatch(final String string, final String pattern) {
    if (pattern.isEmpty()) return string.isEmpty() ? 1 : 0;
    int n = string.length(), m = pattern.length();
    boolean[][] dp = new boolean[n + 1][m + 1];

    dp[0][0] = true;
    for (int i = 1; i <= m; i++)
      if (pattern.charAt(i - 1) == '*')
        dp[0][i] = dp[0][i - 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (pattern.charAt(j - 1) == '*')
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        else if (pattern.charAt(j - 1) == '?' || string.charAt(i - 1) == pattern.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];
      }
    }

    return dp[n][m] ? 1 : 0;
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aa", "a"));
    System.out.println(isMatch("aa", "aa"));
    System.out.println(isMatch("aaa", "aa"));
    System.out.println(isMatch("aa", "*"));
    System.out.println(isMatch("bcaccbabaa", "bb*c?c*?"));
    System.out.println(isMatch("ab", "?*"));
    System.out.println(isMatch("aab", "c*a*b"));
  }
}
