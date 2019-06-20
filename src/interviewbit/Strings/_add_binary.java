package interviewbit.Strings;

public class _add_binary {
  public static String addBinary(String a, String b) {
    StringBuilder builder = new StringBuilder();
    int size = Math.max(a.length(), b.length());
    int carry = 0;
    for (int i = 0; i < size; i++) {
      int c1 = charAt(a, a.length() - i - 1) - '0', c2 = charAt(b, b.length() - i - 1) - '0';
      int sum = c1 + c2;
      if (carry == 0) {
        switch (sum) {
          case 0: builder.append('0'); break;
          case 1: builder.append('1'); break;
          case 2: builder.append('0'); carry = 1; break;
        }
      } else {
        switch (sum) {
          case 0: builder.append('1'); carry = 0; break;
          case 1: builder.append('0'); break;
          case 2: builder.append('1'); break;
        }
      }
    }

    if (carry == 1) {
      builder.append('1');
    }

    return builder.reverse().toString();
  }

  private static char charAt(String num, int index) {
    if (index >= num.length() || index < 0) return '0';
    return num.charAt(index);
  }

  public static void main(String[] args) {
    System.out.println(addBinary("100", "11"));
  }
}
