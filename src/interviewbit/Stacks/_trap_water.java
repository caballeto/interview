package interviewbit.Stacks;

import java.util.*;

public class _trap_water {

  public static int trap(final List<Integer> list) {
    int n = list.size();
    int[] left = new int[n], right = new int[n];
    int water = 0;
    left[0] = list.get(0);
    for (int i = 1; i < list.size(); i++)
      left[i] = Math.max(left[i - 1], list.get(i));

    right[n - 1] = list.get(list.size() - 1);
    for (int i = n - 2; i >= 0; i--)
      right[i] = Math.max(right[i + 1], list.get(i));

    for (int i = 0; i < n; i++)
      water += Math.min(left[i], right[i]) - list.get(i);

    return water;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList( 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
    System.out.println(trap(list));
  }
}
