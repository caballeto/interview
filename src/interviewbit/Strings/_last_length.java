package interviewbit.Strings;

public class _last_length {
  public static int lengthOfLastWord(final String s) {
    boolean last = true;
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == ' ') {
        last = true;
      } else {
        if (last) {
          last = false;
          len = 1;
        } else {
          len++;
        }
      }
    }

    return len;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World   "));
  }
}
