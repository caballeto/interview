package interviewbit.Strings;

public class _min_chars_palindrome {
  public static int solve(String s) {
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < s.length(); i++) {
      if (isPalindrome(s, 0, i)) {
        min = Math.min(min, s.length() - i - 1);
      }
    }

    return min;
  }

  private static boolean isPalindrome(String s, int lo, int hi) {
    int mid = lo + (hi - lo) / 2, len = hi - lo + 1;
    for (int i = lo; i <= mid; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(solve("mmtatbdzqsoemuvnpppsu"));
  }
}
