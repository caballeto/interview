package interviewbit.Stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _sliding_maxwindow {
  public static ArrayList<Integer> slidingMaximum(final List<Integer> list, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {
      if (i >= k && deque.getFirst() <= i - k)
        deque.pollFirst();

      while (!deque.isEmpty() && list.get(deque.getLast()) <= list.get(i))
        deque.pollLast();

      deque.add(i);

      if (i >= k - 1)
        result.add(list.get(deque.getFirst()));
    }

    return result;
  }
}
