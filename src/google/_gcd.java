package google;

public class _gcd {
  public static int gcd(int m, int n) {
    if (n > m) return gcd(n, m);
    if (n == 0) return m;
    return gcd(n, m % n);
  }
}
