package leetcode.session1;

public class _search_2D {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int n = matrix.length, m = matrix[0].length;
    int i = 0, j = m - 1;
    while (i < n && j >= 0) {
      if      (matrix[i][j] == target) return true;
      else if (matrix[i][j] < target)
        i++;
      else
        j--;
    }

    return false;
  }
}
