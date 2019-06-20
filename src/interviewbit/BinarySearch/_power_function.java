package interviewbit.BinarySearch;

public class _power_function {
  public int pow(int x, int n, int d) {
    if (x == 0) return 0;
    if (n == 0) return 1;
    int p = 1, mult = x;

    while (n > 0) {
      if (n % 2 != 0) {
        p = p * mult;
      }

      mult = (mult * mult) % d;
      n /= 2;
      if (p > d)
        p %= d;
    }

    return p;
  }
}
