package interviewbit.Dp;

public class _LIS {
  @SuppressWarnings("Duplicates")
  public static int lis(final int[] array) {
    int[] dp = new int[array.length];
    dp[0] = 1;
    int maxLength = 1;

    for (int i = 1; i < array.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (array[i] > array[j] && dp[j] > max) {
          max = dp[j];
        }
      }

      dp[i] = max + 1;
      maxLength = Math.max(maxLength, dp[i]);
    }

    return maxLength;
  }
}
