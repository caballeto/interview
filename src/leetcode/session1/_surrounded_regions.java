package leetcode.session1;

public class _surrounded_regions {
  static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) return;
    int n = board.length, m = board[0].length;
    boolean[][] marked = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      if (board[i][0] == 'O') dfs(board, marked, i, 0);
      if (board[i][m - 1] == 'O') dfs(board, marked, i, m - 1);
    }

    for (int j = 0; j < m; j++) {
      if (board[0][j] == 'O') dfs(board, marked, 0, j);
      if (board[n - 1][j] == 'O') dfs(board, marked, n - 1, j);
    }

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        board[i][j] = marked[i][j] ? 'O' : 'X';
  }

  void dfs(char[][] board, boolean[][] marked, int x, int y) {
    if (x < 0 || x >= marked.length || y < 0 || y >= marked[0].length || marked[x][y] || board[x][y] == 'X') return;
    marked[x][y] = true;
    for (int[] move : moves)
      dfs(board, marked, x + move[0], y + move[1]);
  }
}
