package interviewbit.Strings;

public class _amazing_substring {
  public static int solve(String s) {
    long sum = 0;

    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) sum += (s.length() - i);
    }

    return (int) (sum % 10003);
  }

  private static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
      c == 'A' || c == 'E' || c == 'I' || c == 'O' ||  c == 'U';
  }
}
