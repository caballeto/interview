package leetcode;

public class _48_rotate_image {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n/2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int val = matrix[i][j];

        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = val;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {
      new int[] {1, 2, 3},
      new int[] {4, 5, 6},
      new int[] {7, 8, 9}
    };

    new _48_rotate_image().rotate(matrix);
    Printer.print(matrix);
  }
}
