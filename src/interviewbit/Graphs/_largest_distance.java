package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.List;

public class _largest_distance {
    public static int solve(int[] tree) {
      List<int[]> graph = new ArrayList<>();
      for (int i = 0; i < tree.length; i++)
        graph.add(new int[2]);
      int max = 0;
      for (int i = tree.length - 1; i > 0; --i) {
        int elem = tree[i];
        int[] parent = graph.get(elem);
        int len = graph.get(i)[0] + 1;

        parent[1] = Math.max(parent[1], len + parent[0]);
        parent[0] = Math.max(parent[0], len);
        max = Math.max(max, parent[1]);
      }

      return max;
    }
}