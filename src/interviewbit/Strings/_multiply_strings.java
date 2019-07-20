package interviewbit.Strings;

public class _multiply_strings {
  public static String multiply(String a, String b) {
    a = removeZeros(a);
    b = removeZeros(b);
    if (a.equals("0") || b.equals("0")) return "0";
    String current = "0";
    for (int i = a.length() - 1; i >= 0; i--) {
      char c = a.charAt(i);
      current = add(multiply(b, c - '0', a.length() - i - 1), current);
    }

    return current;
  }

  private static String removeZeros(String s) {
    if (s.isEmpty()) return s;
    int i = 0;
    while (i < s.length() - 1 && s.charAt(i) == '0') i++;
    return s.substring(i);
  }

  private static String multiply(String s, int n, int order) {
    if (n == 0) return "0";
    if (order == 0) {
      String start = s;
      for (int i = 0; i < n - 1; i++)
        s = add(s, start);
      return s;
    } else {
      return multiply(s, n, 0) + repeat('0', order);
    }
  }

  private static String repeat(char c, int n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++)
      builder.append(c);
    return builder.toString();
  }

  private static String add(String a, String b) {
    if (a.isEmpty() && b.isEmpty()) return "0";
    if (a.isEmpty() || a.equals("0")) return b;
    if (b.isEmpty() || b.equals("0")) return a;
    String max = (a.length() < b.length()) ? b : a;
    String min = (a.length() < b.length()) ? a : b;
    StringBuilder num = new StringBuilder(max);
    int carry = 0, size = min.length();
    for (int i = 0; i < size; i++) {
      int val = (min.charAt(size - 1 - i) - '0') + (max.charAt(max.length() - 1 - i) - '0') + carry;
      if (val >= 10) {
        carry = 1;
        val -= 10;
      } else {
        carry = 0;
      }

      num.setCharAt(num.length() - 1 - i, (char) (val + '0'));
    }

    while (carry > 0 && size < max.length()) {
      int val = (max.charAt(max.length() - 1 - size) - '0') + carry;
      if (val >= 10) {
        carry = 1;
        val -= 10;
        num.setCharAt(max.length() - 1 - size, (char) (val + '0'));
        size++;
      } else {
        num.setCharAt(max.length() - 1 - size, (char) (val + '0'));
        carry = 0;
        break;
      }
    }

    if (carry > 0) {
      num.insert(0, (char) (carry + '0'));
    }

    return num.toString();
  }

  public static void main(String[] args) {
    System.out.println(multiply("0021473700594524297017810575200827941459805716642468749607585313713214621412", "6020453667958309279424408570378228292268488402"));
  }
}
