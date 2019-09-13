package google;

import java.util.Arrays;

public class _longest_matrix_path {
  static int longestPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;
    int n = matrix.length;
    int[][] dp = new int[n][n];
    for (int[] row : dp)
      Arrays.fill(row, -1);

    int max = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, longestPath(matrix, dp, i, j));
      }
    }

    return max;
  }

  static int longestPath(int[][] matrix, int[][] dp, int i, int j) {
    if (dp[i][j] != -1) return dp[i][j];
    int max = 1, val = matrix[i][j];

    if (valid(matrix,i+1, j, val))
      max = Math.max(max, 1 + longestPath(matrix, dp, i+1, j));

    if (valid(matrix, i-1, j, val))
      max = Math.max(max, 1 + longestPath(matrix, dp, i-1, j));

    if (valid(matrix, i, j+1, val))
      max = Math.max(max, 1 + longestPath(matrix, dp, i, j+1));

    if (valid(matrix, i, j-1, val))
      max = Math.max(max, 1 + longestPath(matrix, dp, i, j-1));

    dp[i][j] = max;
    return max;
  }

  static boolean valid(int[][] matrix, int i, int j, int val) {
    return i >= 0 && i < matrix.length && j >= 0 && j < matrix.length && matrix[i][j] - val == 1;
  }

  public static void main(String[] args) {
    System.out.println(longestPath(new int[][]{
      new int[]{1, 2, 9},
      new int[]{5, 3, 8},
      new int[]{4, 6, 7}
    }));
  }
}
