package interviewbit.Hashing;

import java.util.HashSet;
import java.util.Set;

public class _colorful {
  public static int colorful(int n) {
    String s = "" + n;
    Set<Integer> set = new HashSet<>();
    int len = s.length();

    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j <= len; j++) {
        String sub = s.substring(i, j);
        int prod = product(sub);
        if (set.contains(prod)) return 0;
        else {
          set.add(prod);
        }
      }
    }

    return 1;
  }

  private static int product(String s) {
    int prod = 1;
    for (int i = 0; i < s.length(); i++)
      prod *= (s.charAt(i) - '0');
    return prod;
  }

  public static void main(String[] args) {
    System.out.println(colorful(3245));
  }
}
