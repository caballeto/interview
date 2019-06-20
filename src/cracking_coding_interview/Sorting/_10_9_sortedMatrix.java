package cracking_coding_interview.Sorting;

public class _10_9_sortedMatrix {
  // leetcode 240
  public static boolean search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

    int n = matrix.length, m = matrix[0].length;
    int i = 0, j = m - 1;

    while (i < n && j >= 0) {
      int num = matrix[i][j];
      if      (num == target) return true;
      else if (num  > target) j--;
      else                    i++;
    }

    return false;
  }
}
