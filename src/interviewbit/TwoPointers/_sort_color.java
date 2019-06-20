package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class _sort_color {
  public static void sortColors(ArrayList<Integer> list) {
    int[] k = new int[3];
    int[] aux = new int[list.size()];
    for (int val : list)
      k[val]++;
    for (int i = 0; i < k.length - 1; i++)
      k[i + 1] += k[i];
    for (int val : list) {
      aux[k[val] - 1] = val;
      k[val]--;
    }
    for (int i = 0; i < aux.length; i++)
      list.set(i, aux[i]);
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 2, 1, 2, 0, 0));
    sortColors(list);
    System.out.println(list);
  }
}
