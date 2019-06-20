package leetcode;

public class _303_RSQ {
  static class NumArray {
    int[] rsq;

    public NumArray(int[] nums) {
      int n = nums.length;
      rsq = new int[n + 1];
      for (int i = 0; i < n; i++) {
        rsq[i + 1] = rsq[i] + nums[i];
      }
    }

    public int sumRange(int i, int j) {
      return rsq[j + 1] - rsq[i];
    }
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    NumArray array = new NumArray(nums);
    System.out.println(array.sumRange(0, 2));
    System.out.println(array.sumRange(2, 5));
    System.out.println(array.sumRange(0, 5));
  }
}
