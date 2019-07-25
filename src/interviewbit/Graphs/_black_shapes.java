package interviewbit.Graphs;

@SuppressWarnings("Duplicates")
public class _black_shapes {
  public static int black(String[] matrix) {
    int count = 0;
    int n = matrix.length, m = matrix[0].length();
    boolean[][] marked = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i].charAt(j) == 'X' && !marked[i][j]) {
          count++;
          dfs(matrix, marked, i, j);
        }
      }
    }

    return count;
  }

  private static void dfs(String[] matrix, boolean[][] marked, int x, int y) {
    if (x < 0 || x >= marked.length || y < 0 || y >= marked[0].length || marked[x][y] || matrix[x].charAt(y) == 'O')
      return;
    marked[x][y] = true;
    dfs(matrix, marked, x+1, y);
    dfs(matrix, marked, x-1, y);
    dfs(matrix, marked, x, y+1);
    dfs(matrix, marked, x, y-1);
  }
}
