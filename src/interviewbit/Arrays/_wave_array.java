package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _wave_array {
  public static ArrayList<Integer> wave(ArrayList<Integer> list) {
    list.sort(Comparator.naturalOrder());

    for (int i = 0; i < list.size() - 1; i += 2) {
      int temp = list.get(i);
      list.set(i, list.get(i + 1));
      list.set(i + 1, temp);
    }

    return list;
  }

  public static void main(String[] args) {
    System.out.println(wave(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
  }
}
