package interviewbit.Arrays;

import java.util.Arrays;
import java.util.List;

public class _max_gap {
  public static int maximumGap(final List<Integer> list) {
    int[] nums = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      nums[i] = list.get(i);
    Arrays.sort(nums);
    int maxDiff = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++) {
      maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
    }

    return maxDiff;
  }
}
