package interviewbit.Dp;

public class _color_3n_board {
  static final int MOD = 1000000007;

  public static int solve(int n) {
    long color3 = 24;
    long color2 = 12;
    long temp = 0;
    for (int i = 2; i <= n; i++) {
      temp = color3;
      color3 = (11 * color3 + 10 * color2) % MOD;
      color2 = (5 * temp + 7 * color2) % MOD;
    }

    return (int) ((color3 + color2) % MOD);
  }

  public static void main(String[] args) {
    System.out.println(solve(1));
  }
}
