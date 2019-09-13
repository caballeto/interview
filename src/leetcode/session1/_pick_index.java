package leetcode.session1;

import java.util.Arrays;
import java.util.Random;

public class _pick_index {
  class Solution {
    private Random random = new Random();
    private int[] w;
    private int sum;

    public Solution(int[] w) {
      this.w = w;
      for (int i = 1; i < w.length; i++)
        w[i] += w[i - 1];
      this.sum = w[w.length - 1];
    }

    public int pickIndex() {
      int rand = random.nextInt(sum) + 1;
      int index = Arrays.binarySearch(w, rand);
      return (index < 0) ? - 1 - index : index;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.binarySearch(new int[]{2, 3, 6}, 1));
  }

}
