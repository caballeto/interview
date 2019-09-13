package leetcode.session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _reconstruct_queue {
  public static int[][] reconstructQueue(int[][] people) {
    List<int[]> queue = new ArrayList<>();

    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0])
          return o2[0] - o1[0];
        return o1[1] - o2[1];
      }
    });

    for (int[] person : people) {
      int index = person[1];
      if (index < queue.size()) {
        queue.add(index, person);
      } else {
        queue.add(person);
      }
    }

    return queue.toArray(new int[people.length][]);
  }
}
