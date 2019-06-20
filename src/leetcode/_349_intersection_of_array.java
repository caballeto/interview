package leetcode;

import java.util.Arrays;

public class _349_intersection_of_array {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int[] result = new int[Math.min(nums1.length, nums2.length)];
    int index = 0, ptr1 = 0, ptr2 = 0, prev = Integer.MIN_VALUE;
    while (ptr1 < nums1.length && ptr2 < nums2.length) {
      if (nums1[ptr1] == nums2[ptr2] && nums1[ptr1] != prev) {
        result[index++] = nums1[ptr1];
        ptr1++;
        ptr2++;
        prev = nums1[ptr1 - 1];
      } else if (nums1[ptr1] > nums2[ptr2]) {
        ptr2++;
      } else {
        ptr1++;
        prev = nums1[ptr1 - 1];
      }
    }

    return Arrays.copyOf(result, index);
  }
}
