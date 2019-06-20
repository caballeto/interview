package interviewbit.Strings;

public class _strstr {
  public static int strStr(final String haystack, final String needle) {
    if (needle.isEmpty()) return -1;

    int start = 0;

    while (start < haystack.length()) {
      boolean found = true;
      for (int i = start; i < start + needle.length(); i++) {
        if (i >= haystack.length() || needle.charAt(i - start) != haystack.charAt(i)) {
          found = false;
          break;
        }
      }

      if (found) return start;

      start++;
    }

    return -1;
  }
}
