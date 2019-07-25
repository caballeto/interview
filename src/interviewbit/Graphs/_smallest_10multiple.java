package interviewbit.Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _smallest_10multiple {
  public static String multiple(int n) {
    if (n == 0) return "0";
    int[] val = new int[n + 1], par = new int[n + 1], flag = new int[n + 1];
    Arrays.fill(val, -1);
    Arrays.fill(par, -1);

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1 % n);
    par[1 % n] = -1;
    val[1 % n] = flag[1 % n] = 1;

    while (!queue.isEmpty()) {
      int num = queue.poll();

      if (num == 0) {
        StringBuilder s = new StringBuilder();
        while (num != -1) {
          s.append((char) (val[num] + '0'));
          num = par[num];
        }

        return s.reverse().toString();
      }

      int num0 = (num * 10) % n;
      int num1 = (num * 10 + 1) % n;

      if (flag[num0] == 0) {
        flag[num0] = 1;
        par[num0] = num;
        val[num0] = 0;
        queue.add(num0);
      }

      if(flag[num1] == 0) {
        flag[num1] = 1;
        par[num1] = num;
        val[num1] = 1;
        queue.add(num1);
      }
    }

    return "";
  }
}
