package cracking_coding_interview.Bits;

public class _5_2_toBinary {
  public static String toBinary(double num) {
    if (num <= 0 || num >= 1) return "ERROR";
    StringBuilder builder = new StringBuilder();
    builder.append('.');
    while (num > 0) {
      if (builder.length() >=  32) return "ERROR";

      double r = num * 2;
      if (r >= 1) {
        builder.append('1');
        num = r - 1;
      } else {
        builder.append('0');
        num = r;
      }
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(toBinary(0.5));
  }
}
