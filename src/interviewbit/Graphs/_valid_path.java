package interviewbit.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// WRONG SOLUTION
public class _valid_path {
  private static final int[] dirx = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
  private static final int[] diry = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

  private static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static String solve(
    int x,
    int y,
    int n,
    int r,
    ArrayList<Integer> ax,
    ArrayList<Integer> ay
  ) {
    boolean[][] grid = new boolean[x + 1][y + 1];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        for (int k = 0; k < ax.size(); k++) {
          int cx = ax.get(k), cy = ay.get(k);
          if ((cx - i)*(cx - i) + (cy - j)*(cy - j) > r*r) {
            grid[i][j] = true;
          }
        }
      }
    }

    if (!grid[0][0]) return "NO";

    boolean[][] marked = new boolean[x + 1][y + 1];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(0, 0));
    marked[0][0] = true;
    while (!q.isEmpty()) {
      Point point = q.poll();
      for (int i = 0; i < 8; i++) {
        int nx = point.x + dirx[i], ny = point.y + diry[i];
        if (isValid(x, y, nx, ny) && !grid[nx][ny] && !marked[nx][ny]) {
          marked[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }

    return marked[x][y] ? "YES" : "NO";
  }

  private static boolean isValid(int x, int y, int ax, int ay) {
    return ax >= 0 && ay >= 0 && ax <= x && ay <= y;
  }
}
