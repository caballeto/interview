package leetcode;

import java.util.Arrays;

public class _215_kth_largest {
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  public static void main(String[] args) {
    int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
    int k = 4;
    System.out.println(new _215_kth_largest().findKthLargest(nums, k));
  }
}
