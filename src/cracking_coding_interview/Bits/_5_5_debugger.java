package cracking_coding_interview.Bits;

public class _5_5_debugger {
  public boolean isPowerOfTwo(int n) {
    return (n & (n - 1)) == 0;
  }
}
