package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _min_steps {
    private static int dist(int x1, int y1, int x2, int y2) {
      return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
      int sum = 0;
      for (int i = 1; i < A.size(); i++)
        sum += dist(A.get(i), B.get(i), A.get(i - 1), B.get(i - 1));
      return sum;
    }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8));
    ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8));
    System.out.println(coverPoints(a, b));
  }
}
