package cracking_coding_interview.Arrays;

import leetcode.Printer;

public class _1_8_zeroMatrix {
  private static void zeroRow(int[][] matrix, int row) {
    for (int c = 0; c < matrix[0].length; c++) {
      matrix[row][c] = 0;
    }
  }

  private static void zeroCol(int[][] matrix, int col) {
    for (int r = 0; r < matrix.length; r++) {
      matrix[r][col] = 0;
    }
  }

  public static void zeroMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix.length == 1) return;
    int n = matrix.length, m = matrix[0].length;
    boolean zeroHoriz = false;

    for (int j = 0; j < m; j++) {
      if (matrix[0][j] == 0) {
        zeroHoriz = true;
        break;
      }
    }

    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 0) {
        matrix[0][0] = 0;
        break;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < n; i++)
      if (matrix[i][0] == 0) zeroRow(matrix, i);
    for (int j = 1; j < m; j++)
      if (matrix[0][j] == 0) zeroCol(matrix, j);

    if (matrix[0][0] == 0) zeroCol(matrix, 0);
    if (zeroHoriz) zeroRow(matrix, 0);
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3, 4, 0},
      {9, 6, 5, 6, 1},
      {4, 1, 3, 8, 0},
      {7, 4, 2, 8, 2},
      {0, 4, 7, 2, 7}
    };

    zeroMatrix(matrix);
    Printer.print(matrix);
  }
}
