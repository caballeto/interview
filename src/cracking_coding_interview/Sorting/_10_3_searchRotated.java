package cracking_coding_interview.Sorting;

public class _10_3_searchRotated {
  public static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int lo = 0, hi = nums.length - 1, mid;
    while (lo <= hi) {
      mid = (lo + hi) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] >= nums[lo]) {
        if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
        else lo = mid + 1;
      } else {
        if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
        else hi = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3};
    int target = 3;
    System.out.println(search(nums, target));
  }
}
