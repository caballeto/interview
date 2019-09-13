package leetcode.session1;

public class _product_except_self {
  public static int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) return new int[0];
    int n = nums.length, current = 1;
    int[] result = new int[n];

    result[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--)
      result[i] = current *= nums[i + 1];

    current = 1;
    for (int i = 1; i < n; i++)
      result[i] *= current *= nums[i - 1];
    return result;
  }
}
