package interviewbit.Strings;

public class _count_say {
  public static String countAndSay(int n) {
    String s = "1";

    for (int i = 1; i < n; i++) {
      s = update(s);
    }

    return s;
  }

  private static String update(String s) {
    char c = '\0', prev = s.charAt(0);
    int count = 0;
    StringBuilder builder = new StringBuilder();

    int i = 0;
    while (i <= s.length()) {
      if (i != s.length()) {
        c = s.charAt(i);
        count++;
      }

      if (c != prev) {
        builder.append((char) ((count - 1) + '0'));
        builder.append(prev);
        prev = c;
        count = 1;
      } else if (i == s.length()) {
        builder.append((char) (count + '0'));
        builder.append(c);
      }

      i++;
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(countAndSay(10).equals("13211311123113112211"));
  }
}
