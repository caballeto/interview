package cracking_coding_interview.Bits;

public class _5_1_insertion {
  public static int insert(int N, int M, int i, int j) {
    for (int k = i; k <= j; k++) {
      N &= ~(1 << k);
      N |= (M & (1 << (k - i))) << i;
    }

    return N;
  }

  public static void main(String[] args) {
    int N = 0b10000000000;
    int M = 0b10011;
    int i = 2;
    int j = 6;
    System.out.println(Integer.toBinaryString(insert(N, M, i, j)));
  }
}
