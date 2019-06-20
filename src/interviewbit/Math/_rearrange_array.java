package interviewbit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class _rearrange_array {
  public static void arrange(ArrayList<Integer> list) {
    if (list.isEmpty() || list.size() == 1) return;
    Integer[] array = list.toArray(new Integer[0]);
    for (int i = 0; i < list.size(); i++) {
      if (i == array[array[i]]) continue;
      else {
        list.set(i, array[array[i]]);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 0, 2, 1, 3));
    arrange(list);
    System.out.println(list);
  }
}
