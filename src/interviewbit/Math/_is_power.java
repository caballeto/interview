package interviewbit.Math;

public class _is_power {
  public static int isPower(int n) {
    if (n == 1) return 1;
    for (int a = 2; a <= Math.sqrt(n); a++) {
      int p = 2;
      long power = (long) Math.pow(a, p);
      while (power <= n) {
        if (power == n) return 1;
        power = (int) Math.pow(a, ++p);
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(isPower(1002));
  }
}
