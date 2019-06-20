package cracking_coding_interview.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class _1_1_isUnique {
  private static final int R = 26;

  /**
   * Check is all characters in a string are unique
   * O(n) space, O(n) time
   *
   * @param s input string, only [a-z] characters
   * @return true if all chars are unique, false otherwise
   */
  public static boolean isUnique(String s) {
    int[] chars = new int[R];
    for (int i = 0; i < s.length(); i++) {
      chars[s.charAt(i) - 'a']++;
    }
    for (int c : chars) {
      if (c > 1) return false;
    }
    return true;
  }

  /**
   * Using {@code HashSet}
   * O(n) space, O(n) time
   *
   * @param s input string, any characters
   * @return true if all chars are unique, false otherwise
   */
  public static boolean isUniqueH(String s) {
    HashSet<Character> map = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.contains(s.charAt(i))) {
        return false;
      } else {
        map.add(s.charAt(i));
      }
    }

    return true;
  }

  /**
   * Without additional data structures,
   * O(1) space, O(n*log(n)) time
   *
   * @param s input string, any characters
   * @return true if all chars are unique, false otherwise
   */
  public static boolean isUniqueS(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] == chars[i + 1]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isUnique("ababaabc"));      // false
    System.out.println(isUniqueH("abcdefgh"));     // true
    System.out.println(isUniqueS("098123456678")); // false
  }
}
