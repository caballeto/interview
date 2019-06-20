package interviewbit.Bits;

public class _reverse_bits {
  public static long reverse(long num) {
    long n = 0;
    for (int i = 0; i < 32; i++) {
      n |= ((num >> i) & 1) << (31 - i);
    }

    return n;
  }

  public static void main(String[] args) {
    System.out.println(Long.toBinaryString(reverse(3)));
  }
}
