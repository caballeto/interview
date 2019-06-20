package leetcode;

public class _214_shortest_palindrome {
  public String shortestPalindrome(String s) {
    // Use O(n) Manacher algorithm instead
    if (isPalindrome(s)) return s;
    String shortest = "" + s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      String sub = s.substring(0, i + 1);
      if (isPalindrome(sub) && sub.length() > shortest.length()) {
        shortest = sub;
      }
    }

    return reverse(s.substring(shortest.length())) + s;
  }

  private static String reverse(String s) {
    StringBuilder builder = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      builder.append(s.charAt(i));
    }

    return builder.toString();
  }

  private static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length()/2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }

  private static boolean isPalindrome(StringBuilder builder) {
    for (int i = 0; i < builder.length()/2; i++) {
      if (builder.charAt(i) != builder.charAt(builder.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "abbacd";
    System.out.println(new _214_shortest_palindrome().shortestPalindrome(s));
  }
}
