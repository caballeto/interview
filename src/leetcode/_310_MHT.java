package leetcode;

import java.util.*;

public class _310_MHT {
  /*
  private class Graph {
    private List<Integer>[] adj;
    private boolean[] marked;
    private int[] distTo;
    private int V;

    public Graph(int V, int[][] edges) {
      this.V = V;
      this.marked = new boolean[V];
      this.distTo = new int[V];
      this.adj = (List<Integer>[]) new List[V];
      for (int i = 0; i < adj.length; i++) {
        adj[i] = new ArrayList<>();
      }

      for (int[] edge : edges) {
        adj[edge[0]].add(edge[1]);
        adj[edge[1]].add(edge[0]);
      }
    }

    public int mht(int x) {
      reset();
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(x);
      marked[x] = true;
      distTo[x] = 0;
      int distance = Integer.MIN_VALUE;
      while (!queue.isEmpty()) {
        int v = queue.poll();
        for (int w : adj[v]) {
          if (!marked[w]) {
            marked[w] = true;
            distTo[w] = distTo[v] + 1;
            queue.add(w);
            distance = Math.max(distance, distTo[w]);
          }
        }
      }

      return distance;
    }

    private void reset() {
      for (int i = 0; i < marked.length; i++) {
        marked[i] = false;
        distTo[i] = 0;
      }
    }
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Graph graph = new Graph(n, edges);
    int[] vertices = new int[n];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      vertices[i] = graph.mht(i);
      if (vertices[i] < min) min = vertices[i];
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < vertices.length; i++) {
      if (vertices[i] == min) res.add(i);
    }

    return res;
  }
  */

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return Collections.singletonList(0);

    List<Set<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; ++i)
      if (adj.get(i).size() == 1) leaves.add(i);

    while (n > 2) {
      n -= leaves.size();
      List<Integer> newLeaves = new ArrayList<>();
      for (int i : leaves) {
        int j = adj.get(i).iterator().next();
        adj.get(j).remove(i);
        if (adj.get(j).size() == 1) newLeaves.add(j);
      }
      leaves = newLeaves;
    }
    return leaves;
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    System.out.println(new _310_MHT().findMinHeightTrees(n, edges));
  }
}
