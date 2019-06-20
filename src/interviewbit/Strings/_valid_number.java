package interviewbit.Strings;

public class _valid_number {
  public static int isNumber(final String s) {
    String v = s.trim();
    int index = 0;
    boolean fl = false, exp = false, val = false;
    while (index < v.length()) {
      if (v.charAt(index) == ' ') {
        return 0;
      } else if (v.charAt(index) == '+' || v.charAt(index) == '-') {
        index++;
      } else if (isNum(v.charAt(index))) {
        val = true;
        index++;
      } else if (v.charAt(index) == '.') {
        if (!fl) {
          fl = true;
          index++;
          if (index >= s.length() || !(isNum(v.charAt(index))))
            return 0;
          else index++;
          val = true;
        } else return 0;
      } else if (v.charAt(index) == 'e') {
        if (!exp && val) {
          exp = true;
          fl = true;
          index++;

          if (index >= s.length()) return 0;
          else if (isNum(v.charAt(index))) index++;
          else if (v.charAt(index) == '-') {
            index++;

            if (index >= s.length()) return 0;
            else if (isNum(v.charAt(index))) index++;
          }
        } else return 0;
      } else {
        return 0;
      }
    }

    return val ? 1 : 0;
  }

  private static boolean isNum(char c) {
    return c >= '0' && c <= '9';
  }

  public static void main(String[] args) {
    System.out.println(isNumber("3e0.1"));
  }
}
