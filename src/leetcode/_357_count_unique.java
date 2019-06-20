package leetcode;

public class _357_count_unique {
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    int[] dp = new int[n];
    dp[0] = 10;
    int p = 9;
    for (int i = 1; i < n; i++) {
      p *= (10 - i);
      dp[i] = dp[i - 1] + p;
    }

    return dp[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new _357_count_unique().countNumbersWithUniqueDigits(3));
  }
}
