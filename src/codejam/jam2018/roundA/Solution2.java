package codejam.jam2018.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution2 {
  private static class Cache {
    int M, S, P, N;

    public Cache(int M, int S, int P) {
      this.M = M;
      this.S = S;
      this.P = P;
      this.N = 0;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int R = in.nextInt();
      int B = in.nextInt();
      int C = in.nextInt();

      Cache[] caches = new Cache[C];
      for (int j = 0; j < C; j++) {
        caches[j] = new Cache(in.nextInt(), in.nextInt(), in.nextInt());
      }

      int minTime = Integer.MIN_VALUE, currR = R, minVal = Integer.MAX_VALUE;

      for (int j = 1; j <= B; j++) {
        int minIndex = 0;
        for (int k = 0; k < C; k++) {
          if ((caches[k].N > 0 || currR > 0) && (caches[k].S * (caches[k].N + 1) + caches[k].P) < minVal && (caches[k].N + 1) <= caches[k].M) {
            minIndex = k;
            minVal = caches[k].S * (caches[k].N + 1) + caches[k].P;
          }
        }

        caches[minIndex].N++;
        minTime = Math.max(minTime, minVal);
        if (caches[minIndex].N == 1) currR--;
        minVal = Integer.MAX_VALUE;
      }

      System.out.println("Case #" + i + ": " + minTime);
    }
  }
}
