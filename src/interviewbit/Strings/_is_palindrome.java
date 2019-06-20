package interviewbit.Strings;

public class _is_palindrome {
  public static int isPalindrome(String s) {
    return isPalindr(s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
  }

  private static int isPalindr(String s) {
    int n = s.length();
    for (int i = 0; i < n / 2; i++)
      if (s.charAt(i) != s.charAt(n - i - 1))
        return 0;
    return 1;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }
}
