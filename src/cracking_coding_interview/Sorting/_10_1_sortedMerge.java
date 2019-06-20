package cracking_coding_interview.Sorting;

public class _10_1_sortedMerge {
  public static void merge(int[] a, int[] b) {
    int p1 = b.length - 1, p3 = a.length - 1, p2 = a.length - b.length - 1;
    while (p1 >= 0) {
      if (p2 < 0 || b[p1] > a[p2]) {
        a[p3--] = b[p1--];
      } else {
        a[p3--] = a[p2--];
      }
    }
  }
}
