package leetcode;

public class _204_count_primes {
  public int countPrimes(int n) {
    if (n == 0) return 0;
    boolean[] nums = new boolean[n];
    int nprimes = 0;
    for (int i = 0; i < nums.length; i++)
      nums[i] = true;
    nums[0] = false;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i]) {
        nprimes++;
        int num = i + 1;
        for (int j = 1; j * num < n; j++) {
          nums[j * num - 1] = false;
        }
      }
    }

    return nprimes;
  }

  public static void main(String[] args) {
    System.out.println(new _204_count_primes().countPrimes(10));
  }
}
