package cracking_coding_interview.Graphs;

import java.util.ArrayList;

public class DirectedCycleFinder {
  private boolean[] marked;
  private boolean[] onStack;
  private int[] edgeTo;
  private ArrayList<Integer> cycle;

  public DirectedCycleFinder(DirectedGraph G) {
    marked  = new boolean[G.V()];
    onStack = new boolean[G.V()];
    edgeTo  = new int[G.V()];
    for (int v = 0; v < G.V(); v++)
      if (!marked[v] && cycle == null) dfs(G, v);
  }

  private void dfs(DirectedGraph G, int v) {
    onStack[v] = true;
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (cycle != null) return;
      else if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      } else if (onStack[w]) {
        cycle = new ArrayList<>();
        for (int x = v; x != w; x = edgeTo[x])
          cycle.add(x);
        cycle.add(w);
        cycle.add(v);
      }
    }
    onStack[v] = false;
  }

  public boolean hasCycle() {
    return cycle != null;
  }

  public Iterable<Integer> cycle() {
    return cycle;
  }
}
