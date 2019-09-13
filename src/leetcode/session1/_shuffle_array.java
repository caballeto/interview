package leetcode.session1;

import java.util.Arrays;

public class _shuffle_array {
  private int[] nums;
  private int[] reset;

  public _shuffle_array(int[] nums) {
    this.nums = nums;
    this.reset = Arrays.copyOf(nums, nums.length);
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    System.arraycopy(reset, 0, nums, 0, nums.length);
    return nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    for (int index = 0; index < nums.length - 1; index++)
      swap(nums, index, (int) (Math.random() * (nums.length - index) + index));
    return nums;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    _shuffle_array array = new _shuffle_array(new int[]{1, 2, 3});
    System.out.println(Arrays.toString(array.shuffle()));
    System.out.println(Arrays.toString(array.shuffle()));
    System.out.println(Arrays.toString(array.shuffle()));
    System.out.println(Arrays.toString(array.reset()));
  }
}
