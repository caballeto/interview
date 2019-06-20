package cracking_coding_interview.Recursion;

public class _8_2_robotGrid {
  // count paths
  public int countPaths(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int n = grid.length, m = grid[0].length;
    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
      if (grid[0][i] == 1) break;
      dp[0][i] = 1;
    }

    for (int i = 0; i < m; i++) {
      if (grid[i][0] == 1) break;
      dp[i][0] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (grid[i][j] == 1) continue;
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[n - 1][m - 1];
  }
}
