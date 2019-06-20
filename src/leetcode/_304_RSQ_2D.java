package leetcode;

public class _304_RSQ_2D {
  static class NumMatrix {
    int[][] rsq;

    public NumMatrix(int[][] matrix) {
      if (matrix.length == 0) return;
      int n = matrix.length, m = matrix[0].length;
      this.rsq = new int[n + 1][m];
      for (int j = 0; j < m; j++) {
        for (int i = 0; i < n; i++) {
          rsq[i + 1][j] = rsq[i][j] + matrix[i][j];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      for (int j = col1; j <= col2; j++) {
        sum += rsq[row2 + 1][j] - rsq[row1][j];
      }

      return sum;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {3, 0, 1, 4, 2},
      {5, 6, 3, 2, 1},
      {1, 2, 0, 1, 5},
      {4, 1, 0, 1, 7},
      {1, 0, 3, 0, 5}
    };

    NumMatrix rsq = new NumMatrix(matrix);
    System.out.println(rsq.sumRegion(2, 1, 4, 3));
    System.out.println(rsq.sumRegion(1, 1, 2, 2));
    System.out.println(rsq.sumRegion(1, 2, 2, 4));
  }
}
