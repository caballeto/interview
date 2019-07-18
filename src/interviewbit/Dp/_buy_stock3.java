package interviewbit.Dp;

import java.util.List;

@SuppressWarnings("Duplicates")
public class _buy_stock3 {
  public static int maxProfit(final List<Integer> array) {
    if (array.size() <= 1) return 0;
    int firstBuy = Integer.MIN_VALUE;
    int afterFirstSell = 0;
    int afterSecondBuy = Integer.MIN_VALUE;
    int afterSecondSell = 0;

    for (int val : array) {
      firstBuy = Math.max(firstBuy, -val);
      afterFirstSell = Math.max(afterFirstSell, firstBuy + val);
      afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - val);
      afterSecondSell = Math.max(afterSecondSell, afterSecondBuy + val);
    }

    return afterSecondSell;
  }

  public static int maxProfit(int k, final List<Integer> array) {
    if (k == 0) return 0;
    int n = array.size();
    if (k >= n / 2) {
      int max = 0;
      for (int i = 1; i < n; i++) {
        if (array.get(i) > array.get(i - 1)) {
          max += array.get(i) - array.get(i - 1);
        }
      }

      return max;
    }

    int[][] dp = new int[k][2];
    for (int i = 0; i < k; i++) {
      dp[i][0] = Integer.MIN_VALUE;
      dp[i][1] = 0;
    }

    for (int val : array) {
      dp[0][0] = Math.max(dp[0][0], -val);
      dp[0][1] = Math.max(dp[0][1], val + dp[0][0]);
      for (int i = 1; i < k; i++) {
        dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - val);
        dp[i][1] = Math.max(dp[i][1], dp[i][0] + val);
      }
    }

    return dp[k - 1][1];
  }
}
