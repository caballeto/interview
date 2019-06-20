package leetcode;

import java.math.BigInteger;

public class _172_factorial_zeroes {
  public int trailingZeroes(int n) {
    if (n < 5) return 0;
    BigInteger N = BigInteger.valueOf(n);
    BigInteger FIVE = BigInteger.valueOf(5);
    BigInteger prev = BigInteger.ONE;
    while (prev.multiply(FIVE).compareTo(N) <= 0) {
      prev = prev.multiply(FIVE);
    }

    int count = 0;
    while (prev.compareTo(BigInteger.ONE) > 0) {
      count += N.divide(prev).intValue();
      prev = prev.divide(FIVE);
    }

    return count;
  }

  public int trailingZeroesEasy(int n) {
    int ans = 0, p = 1;
    while(n >= Math.pow(5,p)){
      ans += n/Math.pow(5,p);
      p++;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new _172_factorial_zeroes().trailingZeroes(1808548329));
  }
}
