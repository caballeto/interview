package leetcode.session1;

public class _total_hamming_distance {
  public int totalHammingDistance(int[] nums) {
    int total = 0, n = nums.length;
    for (int i = 0; i < 32; i++) {
      int zeros = 0;
      for (int val : nums) {
        if ((val & (1 << i)) == 0) {
          zeros++;
        }
      }

      total += zeros * (n - zeros);
    }

    return total;
  }
}
