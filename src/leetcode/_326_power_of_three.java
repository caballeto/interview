package leetcode;

public class _326_power_of_three {
  public boolean isPowerOfThree(int n) {
    if (n == 0) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
  }

  public static void main(String[] args) {
    System.out.println(new _326_power_of_three().isPowerOfThree(27));
  }
}
