package leetcode;

public class _85_max_rectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;
    final int m = matrix.length, n = matrix[0].length;
    int[] left   = new int[n];
    int[] right  = new int[n];
    int[] height = new int[n];

    for (int i = 0; i < n; i++)
      right[i] = n;

    int max = 0;
    for (int i = 0; i < m; i++) {
      int cleft = 0, cright = n;

      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') height[j]++;
        else height[j] = 0;
      }

      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') left[j] = Math.max(left[j], cleft);
        else {
          left[j] = 0;
          cleft = j + 1;
        }
      }

      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == '1') right[j] = Math.min(right[j], cright);
        else {
          right[j] = n;
          cright = j;
        }
      }

      for (int j = 0; j < n; j++)
        max = Math.max(max, (right[j] - left[j]) * height[j]);
    }

    return max;
  }
}
