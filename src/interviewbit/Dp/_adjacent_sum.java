package interviewbit.Dp;

// https://github.com/royalpranjal/Interview-Bit/blob/master/DynamicProgramming/MaxSumWithoutAdjacentElements.cpp
public class _adjacent_sum {
  public static int adjacent(int[][] matrix) {
    if (matrix.length == 0) return 0;
    int inc = 0, exc = 0;
    for (int i = 0; i < matrix[0].length; i++) {
      int num = Math.max(matrix[0][i], matrix[1][i]);
      int temp = Math.max(exc, inc);
      inc = exc + num;
      exc = temp;
    }

    return Math.max(inc, exc);
  }


  public static void main(String[] args) {
    int[][] matrix = new int[][]{
      new int[]{31, 83, 65, 30, 15},
      new int[]{66, 89, 0, 43, 15}
    };
    System.out.println(adjacent(matrix));
  }
}
