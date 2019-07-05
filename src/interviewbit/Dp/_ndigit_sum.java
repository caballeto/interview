package interviewbit.Dp;

import java.util.Arrays;

public class _ndigit_sum {
  private static int[][] cache;

  public static int solve(int n, int sum) {
    cache = new int[1000][1000];
    for (int[] c : cache) {
      Arrays.fill(c, -1);
    }

    long result = 0;
    for (int i = 1; i <= 9; i++) {
      if (sum - i >= 0) {
        result += count(n - 1, sum - i);
      }
    }

    return (int) (result % 1000000007);
  }

  private static int count(int n, int sum) {
    if (n == 0) return sum == 0 ? 1 : 0;
    if (cache[n][sum] != -1) return cache[n][sum];
    long c = 0;
    for (int i = 0; i < 10; i++) {
      if (sum - i >= 0) {
        c += count(n - 1, sum - i);
      }
    }

    return cache[n][sum] = (int) (c % 1000000007);
  }

  private static int solve(int currentSum, int sum, int currentN, int n) {
    if (currentSum > sum || currentN > n) return 0;
    if (currentSum == sum) {
      return cache[currentSum][currentN] = 1;
    }

    if (cache[currentSum][currentN] != 0) return cache[currentSum][currentN];
    int c = 0;
    int start = currentN == 0 ? 1 : 0;
    for (int i = start; i < 10; i++) {
      if (solve(currentSum + i, sum, currentN + 1, n) != 0) {
        c += (cache[currentSum + i][currentN + 1] % 1000000007);
      }
    }

    return cache[currentSum][currentN] = c;
  }

  public static void main(String[] args) {
    System.out.println(solve(25, 75));
  }
}
