package leetcode.session1;

import java.util.ArrayList;
import java.util.List;

public class _all_duplicates {
  public static List<Integer> findDuplicates(int[] nums) {
    if (nums == null) throw new IllegalArgumentException();
    List<Integer> result = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      int index = nums[i] - 1;
      if (i == index) {
        i++;
      } else if (nums[i] == nums[index]) {
        result.add(nums[i]);
        i++;
      } else if (index < i) {
        nums[index] = nums[i++];
      } else {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
  }
}
