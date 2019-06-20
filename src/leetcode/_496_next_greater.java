package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _496_next_greater {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) {
      map.put(num, indexOf(nums2, num));
    }
    int[] m = new int[nums1.length];
    for (int k = 0; k < nums1.length; k++) {
      int index = map.get(nums1[k]);
      int i = index;
      do {
        i++;
      } while (i < nums2.length && nums2[i] <= nums2[index]);
      m[k] = (i >= nums2.length) ? -1 : nums2[i];
    }

    return m;
  }

  private int indexOf(int[] nums, int num) {
    for (int i = 0; i < nums.length; i++)
      if (num == nums[i]) return i;
    return -1;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{4, 1, 2};
    int[] nums2 = new int[]{1, 3, 4, 2};
    System.out.println(Arrays.toString(new _496_next_greater().nextGreaterElement(nums1, nums2)));
  }
}
