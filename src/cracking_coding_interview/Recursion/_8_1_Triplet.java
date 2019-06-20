package cracking_coding_interview.Recursion;

public class _8_1_Triplet {
  public static int steps(int n) {
    if (n < 0) throw new IllegalArgumentException();
    if (n == 0 || n == 1 || n == 2) return n;
    int a1 = 1, a2 = 1, a3 = 2, res = 0;

    for (int i = 3; i <= n; i++) {
      res = a1 + a2 + a3;
      a1 = a2;
      a2 = a3;
      a3 = res;
    }

    return res;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(steps(i));
    }
  }
}
