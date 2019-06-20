package leetcode;

public class _231_is_power {
  public boolean isPowerOfTwo(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) == 1)
        count++;
      n >>= 1;
    }

    return count == 1;
  }

  public static void main(String[] args) {
    System.out.println(new _231_is_power().isPowerOfTwo(1025));
  }
}
