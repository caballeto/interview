public class Test {
  private static int missing(int[] smaller, int[] bigger) {
    if (smaller == null || smaller.length == 0) return 0;
    int val = smaller[0];
    for (int i = 1; i < smaller.length; i++)
      val ^= smaller[i];
    for (int i = 0; i < bigger.length; i++)
      val ^= bigger[i];
    return val;
  }

  public static void main(String[] args) {
    System.out.println(missing(new int[]{Integer.MAX_VALUE, -Integer.MAX_VALUE, 4, 8, 9, 3, 2, 2},
        new int[]{Integer.MAX_VALUE, -Integer.MAX_VALUE, 4, 8, 9, 3, 2}));
  }
}
