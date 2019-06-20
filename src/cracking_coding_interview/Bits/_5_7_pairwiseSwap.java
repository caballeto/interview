package cracking_coding_interview.Bits;

public class _5_7_pairwiseSwap {
  public static int swap(int num) {
    for (int i = 0; i < 32; i += 2) {
      boolean b1 = (num & (1 << i)) != 0, b2 = (num & (1 << (i + 1))) != 0;

      if (!b1 && b2) {
        num |= (1 << i);
        num &= ~(1 << (i + 1));
      } else if (b1 && !b2) {
        num |= (1 << (i + 1));
        num &= ~(1 << i);
      }
    }

    return num;
  }

  public static int swapS(int num) {
    return ((num & 0xAAAAAAAA) >>> 1) | ((num & 0x55555555) << 1);
  }

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(swap(0b010101)));
    System.out.println(Integer.toBinaryString(swapS(0b010101)));
  }
}
