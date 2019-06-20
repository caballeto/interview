package leetcode;

public class _233_number_of_one {
  public int countDigitOne(int n) {
  if (n <= 0) return 0;
  if (n < 10) return 1;
  int m = numDigits(n), p = (int) Math.pow(10, m - 1), k = n / p;
  return countDigitOne (n % p) + k * countDigitOne(p - 1) + ((k > 1) ? p : (n % p + 1));
}

  private int numDigits(int num) {
    int count = 0;
    while (num != 0) {
      num /= 10;
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(new _233_number_of_one().countDigitOne(155));
  }
}
