package interviewbit.Math;

import java.math.BigInteger;
import java.util.Arrays;

public class _sorted_rank {
  private static final BigInteger VALUE = BigInteger.valueOf(1000003);

  public static int findRank(String s) {
    return (findRankr(s).add(BigInteger.ONE)).remainder(VALUE).intValue();
  }

  private static BigInteger findRankr(String s) {
    if (s.isEmpty()) return BigInteger.ZERO;
    BigInteger rank = factorial(s.length() - 1).multiply(BigInteger.valueOf(less(s, s.charAt(0))));
    return rank.add(findRankr(s.substring(1)));
  }

  private static int less(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < c) count++;
    }

    return count;
  }

  private static BigInteger factorial(int x) {
    BigInteger f = BigInteger.ONE;
    for (int i = 2; i <= x; i++) {
      f = f.multiply(BigInteger.valueOf(i));
    }

    return f;
  }

  public static void main(String[] args) {
    System.out.println(findRank("ZCSFLVHXRYJQKWABGT"));
  }
}
