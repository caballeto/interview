package cracking_coding_interview.Bits;

public class _5_3_flipBits {
  public static int flipBit(int num) {
    int max = Integer.MIN_VALUE, count = 0;
    int i = 0;
    while (i < 32) {
      if ((num & (1 << i)) != 0) {
        count++;
        i++;
      } else {
        count++;
        int k = i + 1;
        while (k < 32 && (num & (1 << k)) != 0) {
          count++;
          k++;
        }

        max = Math.max(max, count);
        count = k - i - 1;
        i = k;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(flipBit(1775));
    System.out.println(flipBit(0b1111011011));
  }
}
