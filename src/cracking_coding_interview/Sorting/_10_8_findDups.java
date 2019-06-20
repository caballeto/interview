package cracking_coding_interview.Sorting;

public class _10_8_findDups {
  public static final int R = 32000;

  public static void countSort(int[] nums) {
    int[] count = new int[R + 1], aux = new int[nums.length];

    for (int num : nums)
      count[num + 1]++;

    for (int i = 1; i <= R; i++)
      count[i] += count[i - 1];

    for (int i = 0; i < nums.length; i++)
      aux[count[nums[i]]++] = nums[i];

    for (int i = 0; i < nums.length; i++)
      nums[i] = aux[i];
  }

  /**
   * Approaches:
   *   O(n^2) - iterate over each entry and check whether it is in array
   *   O(n*log(n)) - sort with quicksort, iterate linearly and check for dups
   *   O(n) - sort with count sort, iterate linearly and check for dups
   *
   * @param nums array to find duplicates from
   */
  public static void printDuplicates(int[] nums) {
    countSort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        System.out.print(nums[i] + " ");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 1, 3, 5, 7, 0};
    printDuplicates(nums);
  }
}
