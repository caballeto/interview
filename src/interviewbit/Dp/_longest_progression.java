package interviewbit.Dp;

import java.util.Arrays;

public class _longest_progression {
  public static int solve(int[] array) {
    int n = array.length;
    if (n <= 2) return n;
    Arrays.sort(array);

    int[][] dp = new int[n][n];
    int llap = 2;

    for (int i = 0; i < n; i++)
      dp[i][n - 1] = 2;

    for (int j = n - 2; j >= 1; j--) {
      int i = j - 1, k = j + 1;
      while (i >= 0 && k <= n - 1) {
        if (array[i] + array[k] < 2 * array[j])
          k++;
        else if (array[i] + array[k] > 2 * array[j]) {
          dp[i][j] = 2;
          i--;
        } else {
          dp[i][j] = dp[j][k] + 1;
          llap = Math.max(llap, dp[i][j]);
          i--; k++;
        }
      }

      while (i >= 0) {
        dp[i][j] = 2;
        i--;
      }
    }

    return llap;
  }
}
