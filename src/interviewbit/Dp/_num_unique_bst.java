package interviewbit.Dp;

public class _num_unique_bst {
  public static int numTrees(int n) {
    if (n == 1) return 1;
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++)
      dp[i] = compute(dp, i);

    return dp[n];
  }

  private static int compute(int[] dp, int n) {
    int numLeft = n - 1, numRight = 0;
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += dp[numLeft--] * dp[numRight++];
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(numTrees(6));
  }
}
