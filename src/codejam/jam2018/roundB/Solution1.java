package codejam.jam2018.roundB;

import java.util.*;
import java.io.*;

public class Solution1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int P = in.nextInt(), Q = in.nextInt();
      int[] X = new int[P], Y = new int[P], Q1 = new int[Q], Q2 = new int[Q];
      char[] D = new char[P];
      for (int j = 0; j < P; j++) {
        X[j] = in.nextInt();
        Y[j] = in.nextInt();
        D[j] = in.next().charAt(0);
      }

      int horiz = 0, vert = 0;
      for (int j = 0; j < P; j++) {
        switch (D[j]) {
          case 'N': {
            for (int k = Y[j] - 1; k >= 0; k--) {
              horiz++;
              Q2[k]++;
            }
            break;
          }
          case 'S': {
            for (int k = Y[j] + 1; k < Q; k++) {
              horiz++;
              Q2[k]++;
            }
            break;
          }
          case 'E': {
            for (int k = X[j] + 1; k < Q; k++) {
              vert++;
              Q1[k]++;
            }
            break;
          }
          case 'W': {
            for (int k = X[j] - 1; k >= 0; k--) {
              vert++;
              Q1[k]++;
            }
            break;
          }
        }
      }

      System.out.println(Arrays.toString(Q1));
      System.out.println(Arrays.toString(Q2));
      int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minSum = Integer.MIN_VALUE;
      for (int j = 0; j < Q; j++) {
        for (int k = 0; k < Q; k++) {
          if (Q1[j] + Q2[k] + vert + horiz > minSum) {
            minSum = Q1[j] + Q2[k] + vert + horiz;
            minX = j;
            minY = k;
          } else if (Q1[j] + Q2[k] + vert + horiz == minSum && j < minX) {
            minSum = Q1[j] + Q2[k] + vert + horiz;
            minX = j;
            minY = k;
          } else if (Q1[j] + Q2[k] + vert + horiz == minSum && j == minX && k < minX) {
            minSum = Q1[j] + Q2[k] + vert + horiz;
            minX = j;
            minY = k;
          }
        }
      }

      System.out.println("Case #" + i + ": " + minX + " " + minY);
    }
  }
}