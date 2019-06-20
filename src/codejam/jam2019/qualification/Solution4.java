package codejam.jam2019.qualification;

import java.util.Scanner;

public class Solution4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int N = input.nextInt();
      int B = input.nextInt();
      int F = input.nextInt();

      int[] broken = new int[B];
      int[] all = new int[N];
      int power = (N > 16) ? 4 : (N > 8) ? 3 : (N > 4) ? 2 : 1;
      int k = (int) Math.pow(2, power);
      StringBuilder command = new StringBuilder(N);
      String response;

      for (int i = 0; i < N; i++) {
        if ((i / k) % 2 == 0) {
          command.setCharAt(i, '1');
        } else {
          command.setCharAt(i, '0');
        }
      }

      for (int i = 0; i < F; i++) {
        System.out.println(command);
        response = input.next();

        if (response.equals("-1")) {
          return;
        } else {
          char c = '1';
          int l = 0;
          int num = (N % k == 0) ? N / k : N / k + 1;
          for (int j = 0; j < num; j++) {
            int count = 0;
            while (response.charAt(l) == c && l < N) {
              count++;
              l++;
            }

            all[j*k] = count;
          }

          k /= 2;
          for (int j = 0; j < N; j++) {
            if ((j / k) % 2 == 0) {
              command.setCharAt(j, '1');
            } else {
              command.setCharAt(j, '0');
            }
          }
          // process command
        }
      }

      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < B - 1; i++) {
        builder.append(broken[i]);
        builder.append(' ');
      }

      System.out.println(builder);
    }
  }
}