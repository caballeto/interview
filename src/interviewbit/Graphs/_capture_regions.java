package interviewbit.Graphs;

import java.util.ArrayList;

public class _capture_regions {
  public static void solve(ArrayList<ArrayList<Character>> board) {
    int n = board.size(), m = board.get(0).size();
    boolean[][] marked = new boolean[n][m];

    for (int j = 0; j < m; j++)
      if (!marked[0][j] && board.get(0).get(j) == 'O')
        dfs(board, marked,0, j);

    for (int j = 0; j < m; j++)
      if (!marked[n - 1][j] && board.get(n - 1).get(j) == 'O')
        dfs(board, marked, n - 1, j);

    for (int i = 0; i < n; i++)
      if (!marked[i][0] && board.get(i).get(0) == 'O')
        dfs(board, marked, i, 0);

    for (int i = 0; i < n; i++)
      if (!marked[i][m - 1] && board.get(i).get(m - 1) == 'O')
        dfs(board, marked, i, m - 1);

    fill(board, marked);
  }

  private static void fill(ArrayList<ArrayList<Character>> board, boolean[][] marked) {
    for (int i = 0; i < marked.length; i++) {
      for (int j = 0; j < marked[0].length; j++) {
        if (marked[i][j]) {
          board.get(i).set(j, 'O');
        } else {
          board.get(i).set(j, 'X');
        }
      }
    }
  }

  private static void dfs(ArrayList<ArrayList<Character>> board, boolean[][] marked, int x, int y) {
    if (x < 0 || x >= marked.length || y < 0 || y >= marked[0].length || marked[x][y] || board.get(x).get(y) == 'X')
      return;
    marked[x][y] = true;
    dfs(board, marked, x+1, y);
    dfs(board, marked, x-1, y);
    dfs(board, marked, x, y+1);
    dfs(board, marked, x, y-1);
  }
}
