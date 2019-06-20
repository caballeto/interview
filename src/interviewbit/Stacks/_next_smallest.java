package interviewbit.Stacks;

import java.util.ArrayList;
import java.util.List;

public class _next_smallest {
  public ArrayList<Integer> prevSmaller(ArrayList<Integer> list) {
    List<Integer> stack = new ArrayList<>();
    ArrayList<Integer> nearest = new ArrayList<>();

    for (int val : list) {
      if (stack.isEmpty()) {
        stack.add(val);
        nearest.add(-1);
      } else {
        while (!stack.isEmpty() && val <= stack.get(stack.size() - 1))
          stack.remove(stack.size() - 1);
        nearest.add(stack.isEmpty() ? -1 : stack.get(stack.size() - 1));
        stack.add(val);
      }
    }

    return nearest;
  }
}
