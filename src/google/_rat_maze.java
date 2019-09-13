package google;

import java.util.Arrays;

public class _rat_maze {
  private static boolean found;

  static int[][] findPath(int[][] maze) {
    if (maze == null) throw new IllegalArgumentException("maze is null");
    int n = maze.length;
    found = false;
    int[][] path = new int[n][n];
    backtrack(maze, path, 0, 0);
    return path;
  }

  private static void backtrack(int[][] maze, int[][] path, int x, int y) {
    if (x < 0 || x >= maze.length || y < 0 || y >= maze.length || path[x][y] != 0 || maze[x][y] != 1) return;
    if (x == maze.length - 1 && y == maze.length - 1) {
      path[x][y] = 1;
      found = true;
      return;
    }

    path[x][y] = 1;
    backtrack(maze, path, x + 1, y);
    if (!found) backtrack(maze, path, x - 1, y);
    if (!found) backtrack(maze, path, x, y - 1);
    if (!found) backtrack(maze, path, x, y + 1);
    if (!found) path[x][y] = 0;
  }

  public static void main(String[] args) {
    int[][] result = findPath(new int[][]{
      {1, 0, 0, 0},
      {1, 1, 0, 1},
      {0, 1, 0, 0},
      {1, 1, 1, 1}
    });

    for (var row : result) {
      System.out.println(Arrays.toString(row));
    }
  }
}
