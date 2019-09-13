package google;

import java.util.Arrays;

public class _practice12 {
  static int solution(Integer[] loads) {
    if (loads == null || loads.length == 0) return 0;
    int n = loads.length;

    Arrays.sort(loads);
    int sum = sum(loads);
    boolean[][] dp = new boolean[n][sum];

    for (int i = 0; i < sum; i++)
      dp[0][i] = (loads[0] == i + 1);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < sum; j++) {
        dp[i][j] = loads[i] == j + 1 || dp[i - 1][j];
        if (j - loads[i] >= 0)
          dp[i][j] = dp[i][j] || dp[i - 1][j - loads[i]];
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= sum; i++) {
      if (dp[n - 1][i - 1]) {
        System.out.println(i);
        min = Math.min(min, Math.abs((sum - i) - i));
      }
    }

    return min;
  }

  public static void main(String[] args) {
    System.out.println(solution(new Integer[]{0, 0, 0}));
  }

  private static int sum(Integer[] array) {
    int sum = 0;
    for (int val : array)
      sum += val;
    return sum;
  }
}
