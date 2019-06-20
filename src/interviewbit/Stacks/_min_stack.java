package interviewbit.Stacks;

import java.util.ArrayList;
import java.util.List;

public class _min_stack {
  class MinStack {
    private class Entry {
      int val;
      int min;

      Entry(int val, int min) {
        this.val = val;
        this.min = min;
      }
    }

    private int n = 0;
    private List<Entry> stack = new ArrayList<>();

    public void push(int x) {
      if (stack.isEmpty())
        stack.add(new Entry(x, x));
      else
        stack.add(new Entry(x, Math.min(x, stack.get(n - 1).min)));
      n++;
    }

    public void pop() {
      if (stack.isEmpty()) return;
      stack.remove(n - 1);
      n--;
    }

    public int top() {
      if (stack.isEmpty()) return -1;
      return stack.get(n - 1).val;
    }

    public int getMin() {
      if (stack.isEmpty()) return -1;
      return stack.get(n - 1).min;
    }
  }
}
