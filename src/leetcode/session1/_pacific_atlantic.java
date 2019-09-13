package leetcode.session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _pacific_atlantic {
  static int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return new ArrayList<>();
    if (matrix.length == 1) {
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < matrix[0].length; i++)
        result.add(Arrays.asList(0, i));
      return result;
    }

    int n = matrix.length, m = matrix[0].length;
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];

    for (int i = 0; i < m; i++) {
      fill(matrix, pacific, 0, i);
      fill(matrix, atlantic, n - 1, i);
    }

    for (int i = 0; i < n; i++) {
      fill(matrix, pacific, i, 0);
      fill(matrix, atlantic, i, m - 1);
    }
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (pacific[i][j] && atlantic[i][j])
          result.add(Arrays.asList(i, j));

    return result;
  }

  private static void fill(int[][] matrix, boolean[][] marked, int i, int j) {
    marked[i][j] = true;
    for (int[] move : moves) {
      int x = i + move[0];
      int y = j + move[1];
      if (x < 0 || y < 0 || x >= marked.length || y >= marked[0].length || marked[x][y] || matrix[i][j] > matrix[x][y])
        continue;
      fill(matrix, marked, x, y);
    }
  }

  public static void main(String[] args) {
    System.out.println(pacificAtlantic(new int[][]{
      {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}
    }));
  }
}
