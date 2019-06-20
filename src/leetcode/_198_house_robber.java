package leetcode;

public class _198_house_robber {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int inc = 0, ex = 0;
    for (int num : nums) {
      int i = inc, e = ex;
      inc = e + num;
      ex = Math.max(i, e);
    }

    return Math.max(inc, ex);
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 1};
    System.out.println(new _198_house_robber().rob(nums));
  }
}
