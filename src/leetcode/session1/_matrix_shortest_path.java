package leetcode.session1;

import java.util.LinkedList;
import java.util.Queue;

public class _matrix_shortest_path {
  static int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

  public static int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    if (n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0, 1});
    grid[0][0] = 1;
    while (!q.isEmpty()) {
      int[] pos = q.poll();
      if (pos[0] == n - 1 && pos[1] == n - 1)
        return pos[2];

      for (int[] move : moves) {
        int row = move[0] + pos[0];
        int col = move[1] + pos[1];
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] == 1)
          continue;
        grid[row][col] = 1;
        q.add(new int[]{row, col, pos[2] + 1});
      }
    }

    return -1;
  }
}
