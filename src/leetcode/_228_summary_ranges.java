package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _228_summary_ranges {
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<>();
    if (nums.length == 0) return ranges;
    if (nums.length == 1) {
      ranges.add("" + nums[0]);
      return ranges;
    }

    int start = nums[0], prev = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 1 + prev) {
        prev++;
      } else {
        if (prev == start) {
          System.out.println(i + " " + prev);
          ranges.add("" + start);
        } else {
          ranges.add(start + "->" + prev);
        }
        prev = nums[i];
        start = nums[i];
      }
    }

    int last = nums[nums.length - 1];
    if (start == last) {
      ranges.add(last + "");
    } else {
      ranges.add(start + "->" + last);
    }

    return ranges;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 2, 3, 4, 6, 8, 9};
    System.out.println(new _228_summary_ranges().summaryRanges(nums));
  }
}
