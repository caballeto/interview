package interviewbit.Dp;

import java.util.ArrayList;
import java.util.HashMap;

public class _dfa {
  private static final long MOD = 1000000007;

  public static int automata(ArrayList<Integer> zeros, ArrayList<Integer> ones, ArrayList<Integer> accept, int start, int n) {
    if (zeros.size() == 0) return 0;
    int nstates = zeros.size();
    long[][] dp = new long[nstates][n + 1];
    HashMap<Integer, Integer> map = new HashMap<>();
    accept.forEach(state -> map.put(state, 1));

    for (int i = 0; i < nstates; i++) {
      if (map.containsKey(i)) {
        dp[i][0] = 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < nstates; j++) {
        dp[j][i] = (dp[zeros.get(j)][i - 1] + dp[ones.get(j)][i - 1]) % MOD;
      }
    }

    return (int) (dp[start][n] % MOD);
  }
}
