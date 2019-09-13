package google;

public class _cover_distance {
  static int count(int n) {
    if (n == 0) return 0;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++)
      for (int j = 1; j <= 3; j++)
        if (i + j <= n)
          dp[i + j] += dp[i];
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(count(3) == 4);
    System.out.println(count(4) == 7);
    System.out.println(count(2) == 2);
  }
}
