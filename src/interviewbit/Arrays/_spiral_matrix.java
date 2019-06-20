package interviewbit.Arrays;

import java.util.ArrayList;

public class _spiral_matrix {
  public static ArrayList<ArrayList<Integer>> generateMatrix(int n) {
    if (n == 0) return new ArrayList<>();
    int[][] matrix = new int[n][n];
    boolean left = false, right = true, bot = false, top = false;
    int i = 0, j = 0, mleft = -1, mright = n, mbot = n, mtop = -1;

    for (int k = 1; k <= n*n; k++) {
      if (left) {
        matrix[i][j--] = k;
      } else if (right) {
        matrix[i][j++] = k;
      } else if (bot) {
        matrix[i++][j] = k;
      } else if (top) {
        matrix[i--][j] = k;
      }

      if (i >= mbot) {
        bot = false;
        left = true;
        i--;
        j--;
        mright--;
      }

      if (i <= mtop) {
        top = false;
        right = true;
        i++;
        j++;
        mleft++;
      }

      if (j >= mright) {
        right = false;
        bot = true;
        j--;
        i++;
        mtop++;
      }

      if (j <= mleft) {
        left = false;
        top = true;
        j++;
        i--;
        mbot--;
      }
    }

    return toList(matrix);
  }

  private static ArrayList<ArrayList<Integer>> toList(int[][] matrix) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int i = 0;
    for (int[] array : matrix) {
      list.add(new ArrayList<>());
      for (int elem : array) {
        list.get(i).add(elem);
      }
      i++;
    }

    return list;
  }

  public static void main(String[] args) {
    System.out.println(generateMatrix(1));
  }
}
