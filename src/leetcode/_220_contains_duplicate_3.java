package leetcode;

import java.util.TreeSet;

public class _220_contains_duplicate_3 {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k <= 0) return false;

    TreeSet<Integer> values = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Integer ceil  = values.ceiling(nums[i] - t);
      if (ceil != null && ceil <= (long) (nums[i] + t)) {
        return true;
      }

      values.add(nums[i]);
      if (i >= k) {
        values.remove(nums[i - k]);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, };
    System.out.println(new _220_contains_duplicate_3().containsNearbyAlmostDuplicate(nums, 1, 1));
  }
}
