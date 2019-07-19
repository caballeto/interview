package interviewbit.Dp;

import java.util.Arrays;

public class _palindrome_partition {
  public static int minCut(String s) {
    int[] cache = new int[s.length() + 1];
    Arrays.fill(cache, -1);
    return minCut(s, 0, cache);
  }

  private static int minCut(String s, int index, int[] cache) {
    if (isPalindrome(s, 0, s.length() - 1)) return 0;
    if (index == s.length() - 1) return 0;
    if (cache[index] != -1) return cache[index];

    int min = Integer.MAX_VALUE;
    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(s, index,  i)) {
        int cuts = minCut(s, i + 1, cache) + ((i + 1 == s.length() ? 0 : 1));
        min = Math.min(min, cuts);
      }
    }

    min = min == Integer.MAX_VALUE ? 0 : min;
    cache[index] = min;
    return min;
  }

  private static boolean isPalindrome(String s, int lo, int hi) {
    if (lo == hi) return true;
    for (int i = lo; i <= lo + (hi - lo) / 2; i++) {
      if (s.charAt(i) != s.charAt(hi - i + lo))
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(minCut("aab"));
  }
}
