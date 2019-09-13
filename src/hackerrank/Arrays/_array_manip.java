package hackerrank.Arrays;

public class _array_manip {
  static long arrayManipulation(int n, int[][] queries) {
    long[] array = new long[n + 1];

    for (int i = 0; i < queries.length; i++) {
      int p = queries[i][0], q = queries[i][1], sum = queries[i][2];
      array[p] += sum;
      if (q + 1 <= n) array[q + 1] -= sum;
    }

    long x = 0, max = Long.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      x += array[i];
      max = Math.max(max, x);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(arrayManipulation(10, new int[][]{
      new int[]{1, 5, 3},
      new int[]{4, 8, 7},
      new int[]{6, 9, 1}
    }));
  }
}
