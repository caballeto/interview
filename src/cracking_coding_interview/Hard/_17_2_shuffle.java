package cracking_coding_interview.Hard;

import java.util.Arrays;

public class _17_2_shuffle {
  public static int range(int min, int max) {
    return (int) (Math.random()*(max - min + 1) + min);
  }

  public static <T> void shuffle(T[] a) {
    shuffle(a, 0, a.length - 1);
  }

  public static <T> void shuffle(T[] a, int lo, int hi) {
    for (int i = lo; i <= hi; i++) {
      int index = range(i, hi);
      swap(a, i, index);
    }
  }

  private static <T> void swap(T[] a, int i, int j) {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    Integer[] a = {1, 5, 6, 3, 1};
    shuffle(a);
    System.out.println(Arrays.toString(a));
  }
}
