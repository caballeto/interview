package interviewbit.Dp;

import java.util.Arrays;

public class _rectangle_permutations {
  public static int solve(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int[][] count = new int[n][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0)
          count[j][i] = matrix[j][i];
        else if (matrix[j][i] == 1)
          count[j][i] = count[j - 1][i] + 1;
        else
          count[j][i] = 0;
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      Arrays.sort(count[i]);
      int max = count[i][0]*m;
      for (int j = 1; j < m; j++)
        max = Math.max(max, count[i][j] * (m - j));
      result = Math.max(result, max);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 0, 0}}));
  }
}
