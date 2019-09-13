package hackerrank.Arrays;

public class _hour_glass {
  private static final int N = 6;

  static int hourglassSum(int[][] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < N - 1; j++) {
        max = Math.max(max, computeSum(i, j, arr));
      }
    }

    return max;
  }

  private static int computeSum(int i, int j, int[][] arr) {
    return arr[i][j] + arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
      + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
  }
}
