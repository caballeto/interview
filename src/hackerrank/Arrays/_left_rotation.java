package hackerrank.Arrays;

public class _left_rotation {
  static int[] rotLeft(int[] a, int d) {
    if (a.length == 0 || d == a.length) return a;
    int[] aux = new int[a.length];
    int j = 0;
    for (int i = d; i < a.length; i++)
      aux[j++] = a[i];
    for (int i = 0; i < d; i++)
      aux[j++] = a[i];
    return aux;
  }
}
