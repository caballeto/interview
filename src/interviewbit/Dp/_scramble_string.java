package interviewbit.Dp;

import java.util.Arrays;

public class _scramble_string {
  public static int isScramble(final String origin, final String _new) {
    return solve(origin, _new) ? 1 : 0;
  }

  private static boolean solve(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    if (s1.equals(s2)) return true;
    char[] a1 = s1.toCharArray(), a2 = s2.toCharArray();
    Arrays.sort(a1);
    Arrays.sort(a2);
    if (!(new String(a1).equals(new String(a2))))
      return false;

    for (int i = 1; i < s1.length(); i++) {
      if(solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i), s2.substring(i)))
        return true;
      if (solve(s1.substring(0, i), s2.substring(s2.length() - i)) && solve(s1.substring(i), s2.substring(0, s2.length() - i)))
        return true;
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(isScramble("great", "rgtae"));
  }
}