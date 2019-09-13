package leetcode.session1;

public class _knight_probability {
  int[][] moves = {{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};

  double knightProbability(int N, int K, int r, int c) {
    double[][][] dp = new double[K + 1][N][N];
    return backtrack(dp, N, K, r, c) / Math.pow(8.0, K);
  }

  private double backtrack(double[][][] dp, int N, int k, int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
    if (k == 0) return 1.0;
    if (dp[k][r][c] != 0) return dp[k][r][c];
    for (int i = 0; i < 8; i++)
      dp[k][r][c] += backtrack(dp, N, k - 1, r + moves[i][0], c + moves[i][1]);
    return dp[k][r][c];
   }
}
