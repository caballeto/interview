package interviewbit.Dp;

public class _chord_count {
  private static int MOD = 1000000007;
  private static long[] dp = new long[1001];

  static {
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < 1001; i++) {
      dp[i] = compute(i) % MOD;
    }
  }

  private static long compute(int n) {
    int left = 0, right = 2*n - 2;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += dp[left / 2] * dp[right / 2] % MOD;
      left += 2;
      right -= 2;
    }

    return sum;
  }

  public static int chordCnt(int n) {
    return (int) (dp[n] % MOD);
  }

  public static void main(String[] args) {
    System.out.println(chordCnt(250));
  }
}
