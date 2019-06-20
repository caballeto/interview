package interviewbit.Math;

public class _palindrome_int {
  /*
  public static int isPalindrome(int a) {
    boolean neg = a < 0;
    a = Math.abs(a);
    int c = a, reverse = 0;
    int count = (int) (Math.log10(a) + 1);
    while (c > 0) {
      reverse += (c % 10) * Math.pow(10, --count);
      c /= 10;

      if (reverse < 0) return 0;
    }

    return (neg) ? -reverse : reverse;
  }
   */

  public static int reverse(int a) {
    try {
      boolean neg = a < 0;
      a = Math.abs(a);
      String s = ((neg) ? "-" : "") + new StringBuilder("" + a).reverse().toString();
      System.out.println(s);
      //return Integer.parseInt((neg) ? "-" : "" + new StringBuilder("" + a).reverse().toString());
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(reverse(-1234567891));
  }
}
