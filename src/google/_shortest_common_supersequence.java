package google;

public class _shortest_common_supersequence {
  static String lcs(String a, String b) {
    if (a.isEmpty() || b.isEmpty()) return "";
    int n = a.length(), m = b.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    StringBuilder builder = new StringBuilder();
    int i = n, j = m;

    while (i >= 1 && j >= 1) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        builder.append(a.charAt(i - 1));
        i--;
        j--;
      } else {
        if (dp[i - 1][j] > dp[i][j - 1])
          i--;
        else
          j--;
      }
    }

    return builder.reverse().toString();
  }


  public static String shortestCommonSupersequence(String a, String b) {
    String common = lcs(a, b);
    if (common.isEmpty()) return a + b;

    StringBuilder builder = new StringBuilder();

    int i = 0, j = 0;
    for (int k = 0; k < common.length(); k++) {
      while (a.charAt(i) != common.charAt(k))
        builder.append(a.charAt(i++));
      i++;

      while (b.charAt(j) != common.charAt(k))
        builder.append(b.charAt(j++));
      j++;

      builder.append(common.charAt(k));
    }

    while (i < a.length())
      builder.append(a.charAt(i++));
    while (j < b.length())
      builder.append(b.charAt(j++));

    return builder.toString();
  }

  static int scs(String X, String Y) {
    int m = X.length();
    int n = Y.length();
    int[][] scs = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          scs[i][j] = j;
        } else if (j == 0) {
          scs[i][j] = i;
        } else if (X.charAt(i - 1) == Y.charAt(j - 1)) { // X, Y are 1-indexed in our definition, 0-indexed in code
          scs[i][j] = 1 + scs[i - 1][j - 1];
        } else {
          scs[i][j] = 1 + Math.min(scs[i - 1][j], scs[i][j - 1]);
        }
      }
    }

    return scs[m][n];
  }

  public static void main(String[] args) {
    System.out.println(shortestCommonSupersequence("abac", "cab"));
    System.out.println(scs("abac", "cab"));
  }
}
