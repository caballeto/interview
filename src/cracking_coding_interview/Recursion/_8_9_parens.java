package cracking_coding_interview.Recursion;

import java.util.ArrayList;
import java.util.List;

public class _8_9_parens {
  public static List<String> valid(int n) {
    if (n <= 0) throw new IllegalArgumentException();
    int index = 0, opened = 0, closed = 0;
    List<String> res = new ArrayList<>();
    generate(res, "", n, index, opened, closed);
    return res;
  }

  private static void generate(List<String> parens, String s, int n, int index, int opened, int closed) {
    if (s.length() == 2*n) {
      if (opened == closed) parens.add(s);
      return;
    }

    if (opened > closed)
      generate(parens, s + ")", n, index + 1, opened, closed + 1);
    generate(parens, s + "(", n, index + 1, opened + 1, closed);
  }

  public static void main(String[] args) {
    System.out.println(valid(3));
  }
}
