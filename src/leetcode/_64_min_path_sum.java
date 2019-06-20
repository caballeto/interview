package leetcode;

public class _64_min_path_sum {
  public int minPathSum(int[][] grid) {
    int n = grid.length, m = grid[0].length;

    int[][] sums = new int[n][m];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        sums[i][j] = Integer.MAX_VALUE;

    sums[0][0] = grid[0][0];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j != m - 1 && sums[i][j] + grid[i][j + 1] < sums[i][j + 1]) {
          sums[i][j + 1] = sums[i][j] + grid[i][j + 1];
        }

        if (i != n - 1 && sums[i][j] + grid[i + 1][j] < sums[i + 1][j]) {
          sums[i + 1][j] = sums[i][j] + grid[i + 1][j];
        }
      }
    }

    return sums[n - 1][m - 1];
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
      new int[] {1, 3, 1},
      new int[] {1, 5, 1},
      new int[] {4, 2, 1}
    };

    System.out.println(new _64_min_path_sum().minPathSum(grid));
  }
}
