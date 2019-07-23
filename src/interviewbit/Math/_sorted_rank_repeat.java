package interviewbit.Math;

import java.math.BigInteger;

public class _sorted_rank_repeat {
  private static final BigInteger VALUE = BigInteger.valueOf(1000003);

  public static int findRank(String s) {
    int n = s.length();
    int total = 1;

    for (int i = 0; i < n; i++) {
      int less = 0;
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) > s.charAt(j)) {
          less++;
        }
      }

      int[] freq = new int[52];

      for (int j = i; j < n; j++) {
        char c = s.charAt(j);
        if (c >= 'A' && c <= 'Z')
          freq[c - 'A']++;
        else
          freq[c - 'a' + 26]++;
      }

      BigInteger prod = BigInteger.ONE;
      for (int val : freq) {
        prod = prod.multiply(factorial(val));
      }

      total += (factorial(n - i - 1).multiply(BigInteger.valueOf(less)).divide(prod)).remainder(VALUE).intValue();
    }

    return total;
  }

  private static BigInteger factorial(int x) {
    BigInteger f = BigInteger.ONE;
    for (int i = 2; i <= x; i++) {
      f = f.multiply(BigInteger.valueOf(i));
    }

    return f;
  }

  public static void main(String[] args) {
    System.out.println(findRank("bbbbaaaa"));
  }
}
