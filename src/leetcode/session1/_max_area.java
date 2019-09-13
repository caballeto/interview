package leetcode.session1;

public class _max_area {
  static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int maxAreaOfIsland(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    int n = grid.length, m = grid[0].length;
    boolean[][] marked = new boolean[n][m];
    int maxArea = 0;

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (grid[i][j] == 1 && !marked[i][j])
          maxArea = Math.max(maxArea, dfs(grid, marked, i, j));

    return maxArea;
  }

  private int dfs(int[][] grid, boolean[][] marked, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || marked[x][y] || grid[x][y] == '0')
      return 0;
    marked[x][y] = true;
    int area = 1;
    for (int[] move : moves)
      area += dfs(grid, marked, x + move[0], y + move[1]);
    return area;
  }
}
