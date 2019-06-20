package cracking_coding_interview.Recursion;

public class _8_3_magicIndex {
  // O(n)
  public int magicBrute(int[] nums) {
    for (int i = 0; i < nums.length; i++)
      if (nums[i] == i) return i;
    return -1;
  }

  public int magic(int[] nums) {
    return magic(nums, 0, nums.length - 1);
  }

  // O(log(n))
  private int magic(int[] nums, int lo, int hi) {
    if (hi < lo) return -1;
    int mid = (lo + hi) / 2;
    if      (nums[mid] > mid) return magic(nums, lo, mid - 1);
    else if (nums[mid] < mid) return magic(nums, mid + 1, hi);
    else return mid;
  }
}
