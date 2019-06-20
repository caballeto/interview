package cracking_coding_interview.Arrays;

public class _1_9_stringRotation {
  /**
   * checks if s1 is a substring of s2
   *
   * @param s1 potential substring
   * @param s2 string
   * @return true if s1 is substring of s2, false otherwise
   */
  private static boolean isSubstring(String s1, String s2) {
    return s2.contains(s1);
  }

  /**
   * checks if s2 is a rotation of s1
   *
   * @param s1 string
   * @param s2 string
   * @return true if s2 is rotation of s1, false otherwise
   */
  public static boolean isRotation(String s1, String s2) {
    return isSubstring(s1, s2 + s2);
  }

  public static void main(String[] args) {
    System.out.println(isRotation("waterbottle", "erbottlewat"));
  }
}
