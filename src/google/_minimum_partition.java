package google;

public class _minimum_partition {
  static int diff(int[] array) {
    if (array == null || array.length == 0) return 0; // undefined
    int n = array.length, sum = sum(array);
    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j - array[i - 1] >= 0)
          dp[i][j] = dp[i][j] || dp[i - 1][j - array[i - 1]];
      }
    }

    int min = sum;
    for (int i = 1; i <= sum/2; i++)
      if (dp[n][i])
        min = Math.min(min, Math.abs(sum - 2*i));

    return min;
  }

  private static int sum(int[] array) {
    int sum = 0;
    for (int val : array)
      sum += val;
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(diff(new int[]{1, 6, 11, 5}) == 1);
    System.out.println(diff(new int[]{3, 1, 4, 2, 2, 1}) == 1);
  }
}
