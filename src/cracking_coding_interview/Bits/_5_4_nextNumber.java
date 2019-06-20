package cracking_coding_interview.Bits;

public class _5_4_nextNumber {
  // Incorrect
  public static void nextNumber(int x) {
    int bits = Counter.count(x);
    int smallest = (1 << bits) - 1, biggest = smallest << (31 - bits);
    System.out.println(smallest);
    System.out.println(biggest);
    System.out.println(Integer.toBinaryString(smallest));
    System.out.println(Integer.toBinaryString(biggest));
  }

  public static void main(String[] args) {
    nextNumber(0b100101111);
  }
}
