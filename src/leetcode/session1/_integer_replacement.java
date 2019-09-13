package leetcode.session1;

import java.util.Arrays;

public class _integer_replacement {
  private static final int MASK = 0b11;

  public static int integerReplacement(int n) {
    if (n == 1) return 0;
    else if (n == 3) {
      return 2;
    } else if (n == Integer.MAX_VALUE) {
      return 32;
    }

    switch (n & MASK) {
      case 0:
      case 0b10:
        return 1 + integerReplacement(n / 2);
      case 0b01:
        return 1 + integerReplacement(n - 1);
      default:
        return 1 + integerReplacement(n + 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(integerReplacement(65535));
    System.out.println(integerReplacement(65535 + 1));
  }
}
