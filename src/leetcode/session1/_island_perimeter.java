package leetcode.session1;

public class _island_perimeter {
  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return 0;
    int n = grid.length, m = grid[0].length;
    boolean[][] marked = new boolean[n][m];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (grid[i][j] == 1)
          return dfs(grid, marked, i, j);
    return 0;
  }

  private int dfs(int[][] grid, boolean[][] marked, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
      return 1;
    if (marked[x][y]) return 0;
    marked[x][y] = true;
    int perim = 0;
    perim += dfs(grid, marked, x + 1, y);
    perim += dfs(grid, marked, x - 1, y);
    perim += dfs(grid, marked, x, y + 1);
    perim += dfs(grid, marked, x, y - 1);

    return perim;
  }
}
