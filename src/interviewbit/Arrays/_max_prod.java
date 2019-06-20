package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class _max_prod {
  private static class Entry {
    int val, index;

    Entry(int val, int index) {
      this.val = val;
      this.index = index;
    }
  }

  public static int maxSpecialProduct(ArrayList<Integer> list) {
    if (list.size() == 1) return 0;
    long[] lsv = new long[list.size()], rsv = new long[list.size()];
    Stack<Entry> stack = new Stack<>();

    for (int i = 0; i < list.size(); i++) {
      int val = list.get(i);

      while (!stack.isEmpty() && stack.peek().val <= val) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        lsv[i] = 0;
      } else {
        lsv[i] = stack.peek().index;
      }

      stack.add(new Entry(list.get(i), i));
    }

    stack.clear();

    for (int i = list.size() - 1; i >= 0; i--) {
      int val = list.get(i);

      while (!stack.isEmpty() && stack.peek().val <= val) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        rsv[i] = 0;
      } else {
        rsv[i] = stack.peek().index;
      }

      stack.add(new Entry(list.get(i), i));
    }

    long max = Long.MIN_VALUE;

    for (int i = 0; i < list.size(); i++) {
      max = Math.max(max, lsv[i]*rsv[i]);
    }

    return (int) (max % 1000000007);
  }

  public static void main(String[] args) {
    System.out.println(maxSpecialProduct(new ArrayList<>(Arrays.asList(3, 2, 1, 2, 3))));
  }
}
