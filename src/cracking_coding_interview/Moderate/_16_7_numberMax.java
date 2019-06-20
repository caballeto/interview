package cracking_coding_interview.Moderate;

public class _16_7_numberMax {
  private static int flip(int bit) {
    return 1^bit;
  }

  static int sign(int a) {
    return flip((a >> 31) & 0x1);
  }

  public static int max(int a, int b) {
    int k = sign(a - b);
    int q = flip(k);
    return a * k + b * q;
  }
}
