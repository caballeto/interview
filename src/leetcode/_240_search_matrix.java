package leetcode;

import java.util.Arrays;

public class _240_search_matrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] row : matrix) {
      if (Arrays.binarySearch(row, target) < 0) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    System.out.println(new _240_search_matrix().searchMatrix(matrix, 20));
  }
}
