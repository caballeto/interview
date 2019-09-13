package leetcode.session1;

import java.util.LinkedList;
import java.util.Queue;

public class _treasure_island {
  static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static int treasureIsland(char[][] map) {
    if (map == null || map.length == 0) return 0;
    int n = map.length, m = map[0].length;
    boolean[][] marked = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    while (!queue.isEmpty()) {
      int[] coords = queue.poll();
      int x = coords[0], y = coords[1], dist = coords[2];
      if (x < 0 || x >= n || y < 0 || y >= m || marked[x][y] || map[x][y] == 'D')
        continue;

      if (map[x][y] == 'X')
        return dist;

      marked[x][y] = true;
      for (int[] move : moves)
        queue.add(new int[]{x + move[0], y + move[1], dist + 1});
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(treasureIsland(new char[][]{
      {'O', 'O', 'O', 'O'},
      {'D', 'O', 'D', 'O'},
      {'O', 'O', 'O', 'O'},
      {'X', 'D', 'D', 'O'}
    }));
  }
}
