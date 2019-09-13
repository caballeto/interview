package leetcode.session1;

public class _valid_palindrome2 {
  public static boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return isPalidrome(s, i, j) || isPalidrome(s, i + 1, j + 1);
      }
    }

    return true;
  }

  private static boolean isPalidrome(String s, int lo, int hi) {
    while (++lo < --hi)
      if (s.charAt(lo) != s.charAt(hi))
        return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(validPalindrome("acda"));
  }
}
