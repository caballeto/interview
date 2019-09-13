package leetcode.session1;

import java.util.List;

public class _social_network {
  public static int countGroups(List<String> related) {
    int n = related.size();
    UF uf = new UF(n);
    for (int r = 0; r < n; r++) {
      String row = related.get(r);
      for (int c = 0; c < n; c++) {
        if (row.charAt(c) == '1') {
          uf.union(r, c);
        }
      }
    }
    return uf.size();
  }

  static class UF {
    private int[] parent;
    private byte[] rank;
    private int size;

    public UF(int n) {
      if (n < 0) throw new IllegalArgumentException();
      parent = new int[n];
      rank = new byte[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
      size = n;
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int pr = find(p);
      int qr = find(q);
      if (pr == qr) return;
      if (rank[pr] < rank[qr]) {
        parent[pr] = qr;
      } else {
        parent[qr] = pr;
        if (rank[pr] == rank[qr]) rank[pr]++;
      }
      size--;
    }

    public int size() {
      return size;
    }
  }
}
