package cracking_coding_interview.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DirectedGraphPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private DirectedGraph G;
  private int s;

  public DirectedGraphPaths(DirectedGraph G, int s) {
    if (s < 0 || s >= G.V()) throw new IllegalArgumentException("invalid source range");
    this.G = G;
    this.s = s;
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    bfs(s);
  }

  private void bfs(int s) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(s); // equivalent to ArrayDeque#addLast
    marked[s] = true;
    while (!queue.isEmpty()) {
      int v = queue.removeFirst();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          marked[w] = true;
          edgeTo[w] = v;
          queue.add(w);
        }
      }
    }
  }

  public int V() {
    return G.V();
  }

  public int s() {
    return s;
  }

  public boolean hasPathTo(int v) {
    validate(v);
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    validate(v);
    List<Integer> path = new ArrayList<>();
    for (int w = v; w != s; w = edgeTo[w])
      path.add(w);
    path.add(s);
    return path;
  }

  private void validate(int v) {
    if (v < 0 || v >= G.V())
      throw new IllegalArgumentException("invalid vertice range");
  }
}
