package interviewbit.Math;

public class _col_number {
  public static int titleToNumber(String string) {
    int number = 0;
    int n = string.length();
    for (int i = 0; i < n; i++) {
      number += (string.charAt(i) - 64) * Math.pow(26, n - i - 1);
    }

    return number;
  }

  public static void main(String[] args) {
    System.out.println(titleToNumber("AB"));
  }
}
