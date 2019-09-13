package google;

import java.util.Arrays;

public class _equal_partition {
  static boolean partition(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return false;
    int sum = sum(array); // assume that integers are positive / non-negative
    if (sum % 2 != 0) return false;
    int n = array.length, half = sum / 2;
    boolean[][] dp = new boolean[n + 1][half + 1];
    //Arrays.sort(array); // maybe unneeded
    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= half; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j - array[i - 1] >= 0)
          dp[i][j] |= dp[i - 1][j - array[i - 1]];
      }
    }

    return dp[n][half];
  }

  private static int sum(int[] array) {
    int sum = 0;
    for (int val : array) {
      sum += val;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(partition(new int[]{1, 5, 11, 5}));
    System.out.println(!partition(new int[]{1, 5, 3}));
    System.out.println(partition(new int[]{3, 1, 1, 2, 2, 1}));
  }
}
