package codejam.jam2019.qualification;

import java.util.*;
import java.io.*;

public class Solution2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      String s = in.next();
      StringBuilder builder = new StringBuilder(s);

      for (int k = 0; k < builder.length(); k++) {
        if (s.charAt(k) == 'E') {
          builder.setCharAt(k, 'S');
        } else {
          builder.setCharAt(k, 'E');
        }
      }

      System.out.println("Case #" + i + ": " + builder.toString());
    }
  }
}