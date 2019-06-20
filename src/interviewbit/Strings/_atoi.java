package interviewbit.Strings;

public class _atoi {
  public static int atoi(final String s) {
    boolean before = true, neg = false;
    int index = 0;
    long val = 0;
    while (index < s.length()) {
      if (s.charAt(index) == ' ') {
        if (before) {
          index++;
        } else {
          break;
        }
      } else if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
        before = false;
        val = val * 10 + (s.charAt(index) - '0');
        if (val > Integer.MAX_VALUE && !neg)
          return Integer.MAX_VALUE;
        else if (val > Integer.MAX_VALUE + 1L && neg)
          return Integer.MIN_VALUE;

        index++;
      } else if (s.charAt(index) == '+') {
        index++;
        before = false;
      } else if (s.charAt(index) == '-') {
        index++;
        neg = true;
        before = false;
      } else {
        break;
      }
    }

    val = (neg) ? -val : val;
    return (int) val;
  }

  public static void main(String[] args) {
    System.out.println(atoi("+7"));
  }
}
