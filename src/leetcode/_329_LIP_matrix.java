package leetcode;

public class _329_LIP_matrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0) return 0;
      int max = 1, n = matrix.length, m = matrix[0].length;
      int[][] cache = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int dist = solve(matrix, cache, i, j);
          if (dist > max) max = dist;
        }
      }

      return max;
    }

    private int solve(int[][] matrix, int[][] cache, int i, int j) {
      if (cache[i][j] != 0) return cache[i][j];
      int max = 1;
      for (int[] dir : dirs) {
        int x = i + dir[0], y = j + dir[1];
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
        int len = 1 + solve(matrix, cache, x, y);
        max = Math.max(max, len);
      }

      cache[i][j] = max;
      return max;
    }

  public static void main(String[] args) {
    int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    System.out.println(new _329_LIP_matrix().longestIncreasingPath(matrix));
  }
}
