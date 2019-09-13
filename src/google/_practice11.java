package google;

import java.util.*;

public class _practice11 {
  static int solution(Integer[] array) {
    if (array == null || array.length == 0) return 0;
    if (array.length == 1) return 1;

    List<Queue<Integer>> rows = new ArrayList<>();
    Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    q.add(array[0]);
    rows.add(q);

    for (int i = 1; i < array.length; i++) {
      int val = array[i];
      Queue<Integer> found = null;
      for (Queue<Integer> queue : rows) {
        if (queue.peek() > val) {
          found = queue;
          break;
        }
      }

      if (found != null) {
        found.add(val);
      } else {
        Queue<Integer> temp = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        temp.add(val);
        rows.add(temp);
      }
    }

    return rows.size();
  }

  public static void main(String[] args) {
    System.out.println(solution(new Integer[]{10, 9, 8, 7, 6, 5, 8, 9, 10}));
  }
}
