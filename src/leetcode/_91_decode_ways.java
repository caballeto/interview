package leetcode;

public class _91_decode_ways {
  public int numDecodings(String s) {
    int n = s.length();
    if (n == 0 || n == 1) return n;
    int[] ways = new int[n + 1];
    ways[0] = 1;
    ways[1] = 1;
    for (int i = 2; i <= n; i++) {
      int num = 10*(s.charAt(i - 2) - 48) + (s.charAt(i - 1) - 48);
      ways[i] = ways[i - 1] + ((num <= 26) ? ways[i - 2] : 0);
    }

    return ways[n];
  }

  public static void main(String[] args) {
    String s = "1123123123";
    System.out.println(new _91_decode_ways().numDecodings(s));
  }
}
