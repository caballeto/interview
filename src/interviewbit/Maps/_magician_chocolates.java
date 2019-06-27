package interviewbit.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _magician_chocolates {
  public static int nchoc(int k, ArrayList<Integer> list) {
    if (list.isEmpty()) return 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
    queue.addAll(list);
    long sum = 0;
    for (int i = 0; i < k; i++) {
      int val = queue.poll();
      sum += val;
      queue.add(val / 2);
    }

    return (int) (sum % 1000000007);
  }

  public static void main(String[] args) {
    System.out.println(nchoc(3, new ArrayList<>(Arrays.asList(6, 5))));
  }
}
