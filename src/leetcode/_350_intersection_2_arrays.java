package leetcode;

import java.util.Arrays;

public class _350_intersection_2_arrays {
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int ptr1 = 0, ptr2 = 0, index = 0;
    int[] result = new int[Math.min(nums1.length, nums2.length)];
    while (ptr1 < nums1.length && ptr2 < nums2.length) {
      if (nums1[ptr1] == nums2[ptr2]) {
        result[index++] = nums1[ptr1];
        ptr1++;
        ptr2++;
      } else if (nums1[ptr1] < nums2[ptr2]) {
        ptr1++;
      } else {
        ptr2++;
      }
    }

    return Arrays.copyOf(result, index);
  }
}
