package interviewbit.Dp;

import java.util.ArrayList;
import java.util.Arrays;

public class _tushar_birthday {
  public static ArrayList<Integer> solve(int R, ArrayList<Integer> list) {
    int min = 0;
    for (int i = 1; i < list.size(); i++)
      if (list.get(i) < list.get(min))
        min = i;
    int size = R / list.get(min), sum = size * list.get(min);
    ArrayList<Integer> s = new ArrayList<>();
    for (int i = 0; i < size; i++) s.add(min);

    for (int i = 0; i < size; i++) {
      for (int j = min - 1; j >= 0; j--) {
        if (sum - list.get(s.get(i)) + list.get(j) <= R) {
          sum = sum - list.get(s.get(i)) + list.get(j);
          s.set(i, j); // change index i to lesser index j, while keeping sum <= R
        }
      }
    }

    return s;
  }

  public static void main(String[] args) {
    System.out.println(solve(11, new ArrayList<>(Arrays.asList(6, 8, 5, 4, 7))));
  }
}
