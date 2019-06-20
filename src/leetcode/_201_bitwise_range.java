package leetcode;

public class _201_bitwise_range {
  public int rangeBitwiseAnd(int m, int n) {
    if (m == 0) return 0;
    int factor = 1;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      factor <<= 1;
    }

    return m * factor;
  }

  public static void main(String[] args) {
    int m = Integer.MAX_VALUE - 1, n = Integer.MAX_VALUE;
    System.out.println(new _201_bitwise_range().rangeBitwiseAnd(m, n));
  }
}
