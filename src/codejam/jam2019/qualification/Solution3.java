package codejam.jam2019.qualification;

import java.io.*;
import java.util.*;

public class Solution3 {
  private static long gcd(long a, long b) {
    while(b > 0) {
      long c = a % b;
      a = b;
      b = c;
    }

    return a;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int L = in.nextInt();
      long[] vals = new long[L];
      for (int j = 0; j < L; j++) {
        vals[j] = in.nextLong();
      }

      long[] gcds = new long[L + 1];
      Set<Long> set = new HashSet<>();
      for (int j = 1; j < L; j++) {
        gcds[j] = gcd(vals[j], vals[j - 1]);
        set.add(gcds[j]);
      }

      gcds[0] = vals[0] / gcds[1];
      gcds[L] = vals[L - 1] / gcds[L - 1];
      set.add(gcds[0]);
      set.add(gcds[L]);
      ArrayList<Long> list = new ArrayList<>(set);
      StringBuilder builder = new StringBuilder();
      Collections.sort(list);
      for (int j = 0; j <= L; j++) {
        builder.append((char) (list.indexOf(gcds[j]) + 65));
      }

      System.out.println("Case #" + i + ": " + builder.toString());
    }
  }
}