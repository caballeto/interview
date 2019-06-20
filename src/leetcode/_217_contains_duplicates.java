package leetcode;

import java.util.HashSet;

public class _217_contains_duplicates {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) return false;
      set.add(num);
    }

    return true;
  }
}
