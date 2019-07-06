package interviewbit.Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _smallest_prime {
  public static int[] solve(int A, int B, int C, int k) {
    int x = 0, y = 0, z = 0;
    int[] res = new int[k + 1];
    res[0] = 1;
    int i = 1;
    Set<Integer> set = new HashSet<>();
    while (i <= k) {
      int temp = Math.min(A*res[x], Math.min(B*res[y], C*res[z]));
      if (!set.contains(temp)) {
        set.add(temp);
        res[i] = temp;
        i++;
      }

      if      (temp == A*res[x]) x++;
      else if (temp == B*res[y]) y++;
      else if (temp == C*res[z]) z++;
    }

    return Arrays.copyOfRange(res, 1, res.length);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solve(5, 7, 8, 5)));
  }
}
