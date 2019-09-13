package leetcode.session1;

import java.util.HashMap;
import java.util.Map;

public class _4sum {
  public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> sums = getSums(A, B);
    int count = 0;

    for (int i : C) {
      for (int j : D) {
        count += sums.getOrDefault(-i-j, 0);
      }
    }

    return count;
  }

  private static Map<Integer, Integer> getSums(int[] a, int[] b) {
    Map<Integer, Integer> sums = new HashMap<>();
    for (int value : a) {
      for (int i : b) {
        sums.put(value + i, sums.getOrDefault(value + i, 0) + 1);
      }
    }

    return sums;
  }
}
