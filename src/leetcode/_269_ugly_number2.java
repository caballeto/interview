package leetcode;

public class _269_ugly_number2 {
  public int nthUglyNumber(int n) {
    int[] nums = new int[n];
    nums[0] = 1;
    int index2 = 0, index3 = 0, index5 = 0;
    int factor2 = 2, factor3 = 3, factor5 = 5;
    for (int i = 1; i < n; i++) {
      int min = Math.min(factor2, Math.min(factor3, factor5));
      nums[i] = min;
      if (nums[i] == factor2)
        factor2 = 2*nums[++index2];
      if (nums[i] == factor3)
        factor3 = 3*nums[++index3];
      if (nums[i] == factor5)
        factor5 = 5*nums[++index5];
    }

    return nums[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new _269_ugly_number2().nthUglyNumber(10));
  }
}
