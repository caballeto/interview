package codejam.jam2019.qualification;

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      String n = in.next();
      StringBuilder builder1 = new StringBuilder(n), builder2 = new StringBuilder(n);
      int k = builder1.length();
      int last = k - 1;
      for (int j = k - 1; j >= 0; j--) {
        if (builder1.charAt(j) == '4') {
          builder1.setCharAt(j, '1');
          builder2.setCharAt(j, '3');
          last = j;
        } else {
          builder2.setCharAt(j, '0');
        }
      }

      System.out.println("Case #" + i + ": " + builder1.toString() + " " + builder2.toString().substring(last));
    }
  }
}