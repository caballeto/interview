package leetcode;

public class _ALGS_recurrence_22 {
  public static double recurrence(int n) {
    double[] vals = new double[n + 1];
    vals[0] = 0;
    vals[1] = 0;
    vals[2] = 0;

    for (int i = 3; i <= n; i++) {
      vals[i] = (i - 3)/ (double) i * vals[i - 1] + 1;
    }

    return vals[n];
  }

  public static void main(String[] args) {
    System.out.println(recurrence(999));
  }
}
