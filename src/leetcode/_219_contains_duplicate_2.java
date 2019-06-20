package leetcode;

import java.util.HashMap;

public class _219_contains_duplicate_2 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int prev = map.getOrDefault(nums[i], -k - 1);
      if (i - prev <= k) return true;
      map.put(nums[i], i);
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3,1,2,3};
    System.out.println(new _219_contains_duplicate_2().containsNearbyDuplicate(nums, 2));
  }
}
