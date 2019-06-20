package cracking_coding_interview.Graphs;

public class _4_1_routeExists {
  private DirectedGraphPaths[] paths;

  public _4_1_routeExists(DirectedGraph G) {
    paths = new DirectedGraphPaths[G.V()];
    for (int i = 0; i < paths.length; i++) {
      paths[i] = new DirectedGraphPaths(G, i);
    }
  }

  public boolean hasPathTo(int v, int w) {
    validate(v);
    validate(w);
    return paths[v].hasPathTo(w);
  }

  public Iterable<Integer> pathTo(int v, int w) {
    if (!hasPathTo(v, w)) return null;
    return paths[v].pathTo(w);
  }

  private void validate(int v) {
    if (v < 0) throw new IllegalArgumentException();
  }
}
