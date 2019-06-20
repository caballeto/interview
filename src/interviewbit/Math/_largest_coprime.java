package interviewbit.Math;

public class _largest_coprime {
  public static int cpFact(int a, int b) {
    int val = gcd(a, b);
    while (val != 1) {
      a /= val;
      val = gcd(a, b);
    }

    return a;
  }

  private static int gcd(int m, int n) {
    if (m < n) return gcd(n, m);
    if (n == 0) return m;
    return gcd(n, m % n);
  }
}
