package interviewbit.BinarySearch;

public class _square_root {
  public static int sqrt(int a) {
    if (a == 1 || a == 0) return a;
    long lo = 1, hi = a;
    long res = 0;
    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;

      if (mid*mid == a)
        return (int) mid;

      if (mid*mid < a) {
        lo = mid + 1;
        res = mid;
      } else {
        hi = mid - 1;
      }
    }

    return (int) res;
  }

  public static void main(String[] args) {
    System.out.println(sqrt(9));
  }
}
