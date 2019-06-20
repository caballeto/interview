package cracking_coding_interview.Moderate;

public class _16_9_operations {
  private static final int ONE = 1 + Integer.MAX_VALUE + Integer.MAX_VALUE;

  public static int mult(int a, int b) {
    int s = 0;
    for (int i = 0; i < b; i++) s += a;
    return s;
  }

  public static int sub(int a, int b) {
    for (int i = 0; i < b; i++) a += ONE;
    return a;
  }

  public static int div(int a, int b) {
    int count = 0;
    while (a >= b) {
      a -= b;
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(mult(5, 4));
    System.out.println(sub(5, 4));
    System.out.println(div(5, 4));
  }
}
