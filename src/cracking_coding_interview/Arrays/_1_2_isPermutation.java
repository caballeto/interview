package cracking_coding_interview.Arrays;

import java.util.Arrays;

public class _1_2_isPermutation {
  private static final int R = 26;

  /**
   * Check if s1 is permutation of s2
   * O(n) space, O(n) time
   *
   * @param s1 input string
   * @param s2 input string
   * @return true if s1 is permutation of s2, false otherwise
   */
  public static boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int[] counts = new int[R];
    for (int i = 0; i < s1.length(); i++) {
      counts[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s2.length(); i++) {
      int index = s2.charAt(i) - 'a';
      counts[index]--;
      if (counts[index] < 0) return false;
    }
    return true;
  }

  /**
   * Check if s1 is permutation of s2
   * O(n) space, O(n*log(n)) time
   *
   * @param s1 input string
   * @param s2 input string
   * @return true if s1 is permutation of s2, false otherwise
   */
  public static boolean isPermutationS(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    var cs1 = s1.toCharArray();
    var cs2 = s2.toCharArray();
    Arrays.sort(cs1);
    Arrays.sort(cs2);
    return Arrays.equals(cs1, cs2);
  }

  public static void main(String[] args) {
    System.out.println(isPermutation("abcd", "cdab"));
    System.out.println(isPermutation("aaaa", "aaab"));
    System.out.println(isPermutationS("abcd", "cdab"));
    System.out.println(isPermutationS("aaaa", "aaab"));
  }
}
