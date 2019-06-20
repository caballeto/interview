package cracking_coding_interview.Sorting;

public class _10_4_noSize {
  public static class Listy {
    int[] nums;

    public Listy(int[] nums) {
      this.nums = nums;
    }

    public int elementAt(int i) {
      if (i >= nums.length) return -1;
      return nums[i];
    }
  }

  public static int nosize(Listy list, int target) {
    if (target <= 0) return -1;
    int lo = 0, hi = Integer.MAX_VALUE, mid, elem;
    while (lo <= hi) {
      mid = (lo + hi) / 2;
      elem = list.elementAt(mid);
      if (elem == -1) hi = mid - 1;
      else if (elem == target) return mid;
      else if (target < elem) hi = mid - 1;
      else lo = mid + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 4, 7, 12, 32, 453, 123123};
    int target = 12;
    System.out.println(nosize(new Listy(nums), target));
  }
}
