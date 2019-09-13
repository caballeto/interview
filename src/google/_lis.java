package google;

public class _lis {
  private static int lis(int[] array) {
    if (array == null || array.length == 0) return 0;
    int n = array.length, maxLen = 0;
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      int max = 0, val = array[i];
      for (int j = 0; j < i; j++) {
        if (val > array[j]) {
          max = Math.max(max, dp[j]);
        }
      }

      dp[i] = 1 + max;
      maxLen = Math.max(maxLen, dp[i]);
    }

    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(lis(new int[]{3, 10, 2, 1, 20}) == 3);
    System.out.println(lis(new int[]{3, 2}) == 1);
    System.out.println(lis(new int[]{50, 3, 10, 7, 40, 80}) == 4);
  }
}
