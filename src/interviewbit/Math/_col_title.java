package interviewbit.Math;

public class _col_title {
  public static String convertToTitle(int n) {
    StringBuilder builder = new StringBuilder();
    if (n % 26 == 0) {
      builder.append('Z');
      while (n % 26 == 0) {
        builder.append('Y');
        n /= 26;
      }

      n--;
    }

    while (n > 1) {
      int val = n % 26;
      builder.append((char) (val + 64));
      n -= val;
      n /= 26;
    }

    return builder.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(convertToTitle(676));
  }
}
