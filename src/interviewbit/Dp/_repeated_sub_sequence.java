package interviewbit.Dp;

public class _repeated_sub_sequence {
  public static int anytwo(String s) {
    if (s.length() <= 2) return 0;
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == s.charAt(j - 1) && i != j)
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
      }
    }

    return dp[n][n] < 2 ? 0 : 1;
  }

  public static void main(String[] args) {
    System.out.println(anytwo("abab"));
  }
}
