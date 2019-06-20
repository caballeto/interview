package interviewbit.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _largest_rectangle {
  public ArrayList<Integer> left(ArrayList<Integer> list) {
    List<Integer> stack = new ArrayList<>();
    ArrayList<Integer> nearest = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {
      int val = list.get(i);
      if (stack.isEmpty()) {
        nearest.add(-1);
      } else {
        while (!stack.isEmpty() && val <= list.get(stack.get(stack.size() - 1)))
          stack.remove(stack.size() - 1);
        nearest.add(stack.isEmpty() ? -1 : stack.get(stack.size() - 1));
      }

      stack.add(i);
    }

    return nearest;
  }

  public ArrayList<Integer> right(ArrayList<Integer> list) {
    List<Integer> stack = new ArrayList<>();
    ArrayList<Integer> nearest = new ArrayList<>();
    int len = list.size();
    for (int i = len - 1; i >= 0; i--) {
      int val = list.get(i);
      if (stack.isEmpty()) {
        nearest.add(len);
      } else {
        while (!stack.isEmpty() && val <= list.get(stack.get(stack.size() - 1)))
          stack.remove(stack.size() - 1);
        nearest.add(stack.isEmpty() ? len : stack.get(stack.size() - 1));
      }
      stack.add(i);
    }

    ArrayList<Integer> reverse = new ArrayList<>();
    for (int i = nearest.size() - 1; i >= 0; i--) reverse.add(nearest.get(i));
    return reverse;
  }

  public int largestRectangleArea(ArrayList<Integer> list) {
    List<Integer> left = left(list), right = right(list);
     int max = Integer.MIN_VALUE;
     for (int i = 0; i < list.size(); i++) {
       max = Math.max(max, (right.get(i) - left.get(i) - 1) * list.get(i));
     }

     return max;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
    System.out.println(new _largest_rectangle().largestRectangleArea(list));
  }
}
