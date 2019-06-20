package leetcode;

public class _63_uniq_path2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length, m = obstacleGrid[0].length;
    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; i++) {
      if (obstacleGrid[i][0] == 1) break;
      matrix[i][0] = 1;
    }

    for (int j = 0; j < m; j++) {
      if (obstacleGrid[0][j] == 1) break;
      matrix[0][j] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (obstacleGrid[i][j] == 1) continue;
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
      }
    }

    return matrix[n - 1][m - 1];
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
      new int[] {0, 0, 0},
      new int[] {0, 1, 0},
      new int[] {0, 0, 0}
    };

    System.out.println(new _63_uniq_path2().uniquePathsWithObstacles(grid));
  }
}
