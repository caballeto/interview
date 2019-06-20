package cracking_coding_interview.Graphs;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
  private final int V;
  private int E;

  private LinkedList<Integer>[] adj;

  @SuppressWarnings("unchecked")
  public DirectedGraph(int V) {
    this.V = V;
    this.E = 0;
    this.adj = (LinkedList<Integer>[]) new LinkedList[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public List<Integer> adj(int v) {
    validate(v);
    return adj[v];
  }

  public void addEdge(int v, int w) {
    validate(v);
    validate(w);
    E++;
    adj[v].add(w);
  }

  public int degree(int v) {
    validate(v);
    return adj[v].size();
  }

  private void validate(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertice should be positive");
  }
}
