package leetcode;

public class _162_peak_element {
  public int findPeakElement(int[] nums) {
    return min(0, nums.length - 1, nums);
  }

  private int min(int lo, int hi, int[] nums) {
    if (lo <= hi + 2) {
      if (lo == 0 && nums[lo] > nums[1]) return 0;
      if (lo != 0 && nums[lo] > nums[lo + 1] && nums[lo] > nums[lo - 1]) return lo;

      int last = nums.length - 1;
      if (hi == last && nums[hi] > nums[hi - 1]) return hi;
      if (hi != last && nums[hi] > nums[hi - 1] && nums[hi] > nums[hi + 1]) return hi;

      if (hi != lo + 1 && nums[lo + 1] > nums[lo] && nums[lo + 1] > nums[lo + 2])
        return lo;
      return -1;
    }

    int mid = (lo + hi) / 2;
    if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
      return mid;
    }

    if (nums[mid + 1] > mid)
      return min(mid + 1, hi, nums);
    else return min(lo, mid - 1, nums);
  }
}
