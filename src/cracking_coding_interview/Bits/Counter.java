package cracking_coding_interview.Bits;

public class Counter {
  public static int count(int x) {
    int count = 0;
    while (x > 0) {
      if ((x & 1) == 1) count++;
      x >>>= 1;
    }

    return count;
  }
}
