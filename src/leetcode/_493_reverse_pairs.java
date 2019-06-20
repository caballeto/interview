package leetcode;

public class _493_reverse_pairs {
  public int reversePairs(int[] nums) {
    int[] aux = new int[nums.length];
    return mergeSort(nums, aux,0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int[] aux, int lo, int hi) {
    if (hi <= lo) return 0;
    int mid = (lo + hi) / 2;
    int inv = 0;
    inv += mergeSort(nums, aux, lo, mid);
    inv += mergeSort(nums, aux,mid + 1, hi);
    int j = mid + 1;
    for (int i = lo; i <= mid; i++) {
      while (j <= hi && nums[i] > 2L * nums[j])
        j++;
      inv += j - (mid + 1);
    }
    merge(nums, aux, lo, mid, hi);
    return inv;
  }

  private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++)
      aux[k] = nums[k];

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if      (i > mid)         nums[k] = aux[j++];
      else if (j > hi)          nums[k] = aux[i++];
      else if (aux[j] < aux[i]) nums[k] = aux[j++];
      else                      nums[k] = aux[i++];
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 2, 3, 1};
    System.out.println(new _493_reverse_pairs().reversePairs(nums));
  }
}
