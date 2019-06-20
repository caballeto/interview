package cracking_coding_interview.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DirectedDFS {
  private boolean[] marked;
  private ArrayList<Integer> postorder;

  public DirectedDFS(DirectedGraph G) {
    this.marked = new boolean[G.V()];
    this.postorder = new ArrayList<>();
    for (int v = 0; v < G.V(); v++)
      if (!marked[v]) dfs(G, v);
  }

  private void dfs(DirectedGraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        dfs(G, w);
      }
    }
    postorder.add(v);
  }

  public Iterable<Integer> reversePost() {
    ArrayDeque<Integer> reverse = new ArrayDeque<>();
    for (int v : postorder)
      reverse.addFirst(v);
    return reverse;
  }

  public boolean hasPathTo(int v) {
    validate(v);
    return marked[v];
  }

  private void validate(int v) {
    if (v < 0) throw new IllegalArgumentException();
  }
}
