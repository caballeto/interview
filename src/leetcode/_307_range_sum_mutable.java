package leetcode;

public class _307_range_sum_mutable {
  private int[] rsq;
  private int[] nums;

  public _307_range_sum_mutable(int[] nums) {
    this.nums = nums;
    this.rsq = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      rsq[i] = rsq[i - 1] + nums[i - 1];
    }
  }

  public void update(int i, int val) {
    int diff = nums[i] - val;
    nums[i] = val;
    for (int j = i + 1; j <= nums.length; j++) {
      rsq[j] -= diff;
    }
  }

  public int sumRange(int i, int j) {
    return rsq[j + 1] - rsq[i];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1};
    _307_range_sum_mutable range = new _307_range_sum_mutable(nums);

    System.out.println(range.sumRange(0, 0));
    range.update(0, 1);
    System.out.println(range.sumRange(0, 0));
  }
}
