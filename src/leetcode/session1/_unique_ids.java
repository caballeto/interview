package leetcode.session1;

import java.util.Arrays;

public class _unique_ids {
  public int getUniqueUserIdSum(int[] arr) {
    if (arr == null) throw new IllegalArgumentException();
    Arrays.sort(arr);
    int sum = 0, min = 0;
    for (int val : arr) {
      min = Math.max(val, min + 1);
      sum += min;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(new _unique_ids().getUniqueUserIdSum(new int[]{3, 2, 1, 2, 7}));
  }
}
