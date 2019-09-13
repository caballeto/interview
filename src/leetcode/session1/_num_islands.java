package leetcode.session1;

public class _num_islands {
  static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    int n = grid.length, m = grid[0].length;
    boolean[][] marked = new boolean[n][m];
    int count = 0;

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (!marked[i][j] && grid[i][j] == '1') {
          dfs(grid, marked, i, j);
          count++;
        }

    return count;
  }

  private void dfs(char[][] grid, boolean[][] marked, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || marked[x][y] || grid[x][y] == '0')
      return;
    marked[x][y] = true;
    for (int[] move : moves)
      dfs(grid, marked, x + move[0], y + move[1]);
  }
}
