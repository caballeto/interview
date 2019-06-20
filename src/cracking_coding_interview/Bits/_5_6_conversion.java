package cracking_coding_interview.Bits;

public class _5_6_conversion {
  public static int conv(int a, int b) {
    return Counter.count(a ^ b);
  }

  public static void main(String[] args) {
    System.out.println(conv(29, 15));
  }
}
