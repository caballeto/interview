package google;

import java.util.ArrayList;
import java.util.List;

public class _course_schedule {
  static class Graph {
    private int V;
    private List<Integer>[] adj;
    private boolean cycle;
    private boolean[] marked;
    private boolean[] onStack;

    Graph(int V) {
      this.V = V;
      marked = new boolean[V];
      onStack = new boolean[V];
      adj = (List<Integer>[]) new ArrayList[V];
      for (int v = 0; v < V; v++)
        adj[v] = new ArrayList<>();
    }

    private void dfs(int v) {
      marked[v] = true;
      onStack[v] = true;

      for (int w : adj[v]) {
        if (cycle) return;
        else if (!marked[w]) {
          dfs(w);
        } else if (onStack[w]) {
          cycle = true;
          return;
        }
      }

      onStack[v] = false;
    }

    boolean hasCycle() {
      for (int v = 0; v < V; v++)
        if (!marked[v]) dfs(v);
      return cycle;
    }

    void addEdge(int v, int w) {
      adj[v].add(w);
    }
  }

  public static boolean canFinish(int V, int[][] prerequisites) {
    if (V == 0) return true;
    Graph G = new Graph(V);
    for (int[] pair : prerequisites)
      G.addEdge(pair[1], pair[0]);
    return !G.hasCycle();
  }

  public static void main(String[] args) {
    System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 0}}));
  }
}
