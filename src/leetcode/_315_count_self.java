package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _315_count_self {
  // Binary Index tree
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> counts = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i]) count++;
      }
      counts.add(count);
    }

    return counts;
  }
}
