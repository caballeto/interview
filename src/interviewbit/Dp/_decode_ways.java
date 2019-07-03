package interviewbit.Dp;

public class _decode_ways {
  public static int numDecodings(String s) {
    int n = s.length();
    if (n == 0 || s.charAt(0) == '0') return 0;
    if (n == 1) return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = 0;
      if (s.charAt(i - 1) - '0' > 0)
        dp[i] = dp[i - 1];
      if (s.charAt(i - 1) == '0' && s.charAt(i - 2) > '2')
        return 0;
      if ((s.charAt(i - 2) - '0' == 1) || (s.charAt(i - 2) - '0' == 2 && s.charAt(i - 1) - '0' <= 6))
        dp[i] = dp[i] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("2611055971756562"));
  }
}
