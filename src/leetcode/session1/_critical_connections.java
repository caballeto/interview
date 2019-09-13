package leetcode.session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _critical_connections {
  private int time;
  private int[] discoverTimes;
  private int[] earlyNodes;
  private boolean[] marked;
  private List<Integer>[] graph;

  public List<List<Integer>> findBridges(int n, int[][] edges) {
    List<List<Integer>> bridges = new ArrayList<>();
    graph = buildGraph(n, edges);
    discoverTimes = new int[n + 1];
    earlyNodes = new int[n + 1];
    marked = new boolean[n + 1];
    time = 1;
    visit(1, -1, bridges);
    return bridges;
  }

  private void visit(int at, int parent, List<List<Integer>> bridges) {
    marked[at] = true;
    discoverTimes[at] = time;
    earlyNodes[at] = time;
    time++;

    for (int to : graph[at]) {
      if (to == parent) continue;
      if (!marked[to]) {
        visit(to, at, bridges);
        earlyNodes[at] = Math.min(earlyNodes[at], earlyNodes[to]);
        if (discoverTimes[at] < earlyNodes[to]) {
          bridges.add(Arrays.asList(at, to));
        }
      } else {
        earlyNodes[at] = Math.min(earlyNodes[at], earlyNodes[to]);
      }
    }
  }

  private List<Integer>[] buildGraph(int n, int[][] edges) {
    List<Integer>[] graph = (List<Integer>[]) new List[n + 1];
    Arrays.setAll(graph, i -> new ArrayList<>());
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph[u].add(v);
      graph[v].add(u);
    }
    return graph;
  }
}
