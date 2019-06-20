package cracking_coding_interview.Moderate;

import java.util.Arrays;

public class _16_4_smallestDiff {
  public static int diff(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int i = 0, j = 0;
    int d, minDiff = Integer.MAX_VALUE;
    while (i < a.length || j < b.length) {
      if (i >= a.length || j >= b.length) break;
      d = Math.abs(a[i] - b[j]);
      if (d < minDiff) minDiff = d;
      if (i < a.length - 1 && j < b.length - 1 && Math.abs(a[i] - b[j + 1]) > Math.abs(a[i + 1] - b[j]))
        i++;
      else j++;
    }

    return minDiff;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 15, 11, 2}, b = {23, 127, 235, 19, 8};
    System.out.println(diff(a, b));
  }
}
