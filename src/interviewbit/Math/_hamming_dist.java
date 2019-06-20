package interviewbit.Math;

import java.util.Arrays;
import java.util.List;

public class _hamming_dist {
  public static int hammingDistance(final List<Integer> a) {
    long sum = 0;

    for (int i = 0; i < 32; i++) {
      long delta = 0;
      for (int val : a) {
        delta += (val >> i) & 1;
      }

      sum += delta * (a.size() - delta);
    }

    return (int) ((2*sum) % 1000000007);
  }

  public static void main(String[] args) {
    System.out.println(hammingDistance(Arrays.asList(2, 4, 6)));
  }
}
