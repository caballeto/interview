package cracking_coding_interview.Arrays;

public class _1_6_stringCompression {
  public static String compress(String s) {
    if (s == null || s.length() == 0 || s.length() == 1) return s;
    char curr = s.charAt(1), prev = s.charAt(0);
    int count = 1, i = 1;
    StringBuilder builder = new StringBuilder();
    while (i < s.length()) {
      curr = s.charAt(i);
      if (curr == prev) {
        count++;
      } else {
        builder.append(prev).append(count);
        prev = curr;
        count = 1;
      }
      i++;
    }

    builder.append(curr).append(count);

    return builder.length() > s.length() ? s : builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(compress("aabccccaaa"));
    System.out.println(compress("a"));
    System.out.println(compress("aaaaaaa"));
    System.out.println(compress("abcdefgh"));
  }
}
