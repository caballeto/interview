package leetcode;

import java.util.*;

public class _699_falling_squares {
  public List<Integer> fallingSquares(int[][] positions) {
    Set<Integer> coords = new HashSet<>();
    for (int[] pos: positions) {
      coords.add(pos[0]);
      coords.add(pos[0] + pos[1] - 1);
    }
    List<Integer> sortedCoords = new ArrayList<>(coords);
    Collections.sort(sortedCoords);

    Map<Integer, Integer> index = new HashMap<>();
    int t = 0;
    for (int coord : sortedCoords) {
      index.put(coord, t++);
    }

    SegmentTree tree = new SegmentTree(sortedCoords.size());
    int best = 0;
    List<Integer> ans = new ArrayList<>();

    for (int[] pos: positions) {
      int L = index.get(pos[0]);
      int R = index.get(pos[0] + pos[1] - 1);
      int h = tree.query(L, R) + pos[1];
      tree.update(L, R, h);
      best = Math.max(best, h);
      ans.add(best);
    }
    return ans;
  }

  class SegmentTree {
    int N, H;
    int[] tree, lazy;

    public SegmentTree(int N) {
      this.N = N;
      this.H = 1;
      while ((1 << H) < N) H++; // find height / log
      tree = new int[2*N];
      lazy = new int[N];
    }

    private void apply(int x, int val) {
      tree[x] = Math.max(tree[x], val);
      if (x < N) lazy[x] = Math.max(lazy[x], val);
    }

    private void pull(int x) {
      while (x > 1) {
        x >>= 1;
        tree[x] = Math.max(tree[2*x], tree[2*x + 1]);
        tree[x] = Math.max(tree[x], lazy[x]);
      }
    }

    private void push(int x) {
      for (int h = H; h > 0; h--) {
        int y = x >> h;
        if (lazy[y] > 0) {
          apply(y * 2, lazy[y]);
          apply(y * 2 + 1, lazy[y]);
          lazy[y] = 0;
        }
      }
    }

    public void update(int L, int R, int h) {
      L += N; R += N;
      int L0 = L, R0 = R;
      while (L <= R) {
        if ((L & 1) == 1) apply(L++, h);
        if ((R & 1) == 0) apply(R--, h);
        L >>= 1; R >>= 1;
      }
      pull(L0); pull(R0);
    }

    public int query(int L, int R) {
      L += N; R += N;
      int ans = 0;
      push(L); push(R);
      while (L <= R) {
        if ((L & 1) == 1) ans = Math.max(ans, tree[L++]);
        if ((R & 1) == 0) ans = Math.max(ans, tree[R--]);
        L >>= 1; R >>= 1;
      }
      return ans;
    }
  }

  /* My solution
  public List<Integer> fallingSquares(int[][] positions) {
    List<Integer> heights = new ArrayList<>(positions.length);
    List<int[]> intervals = new ArrayList<>();
    int hmax = positions[0][1];
    heights.add(hmax);
    intervals.add(new int[]{positions[0][0], positions[0][0]+positions[0][1], positions[0][1]});
    for (int i = 1; i < positions.length; i++) {
      int[] interval = new int[]{positions[i][0], positions[i][0]+positions[i][1], positions[i][1]};
      int[] maxInterval = findMax(intervals, interval);
      int h = (maxInterval == null) ? 0 : maxInterval[2];
      interval[2] += h;
      intervals.add(interval);
      hmax = Math.max(hmax, interval[2]);
      heights.add(hmax);
    }

    return heights;
  }

  private int[] findMax(List<int[]> intervals, int[] interval) {
    int maxH = Integer.MIN_VALUE;
    int[] maxInterval = null;
    for (int[] inter : intervals) {
      if ((interval[0] >= inter[0] && interval[0] < inter[1]) ||
          (interval[1] > inter[0] && interval[1] <= inter[1]) ||
          (interval[0] >= inter[0] && interval[1] <= inter[1]) ||
          (interval[0] <= inter[0] && interval[1] >= inter[1])) {
        if (maxH < inter[2]) {
          maxH = inter[2];
          maxInterval = inter;
        }
      }
    }

    return maxInterval;
  }
  */

  public static void main(String[] args) {
    int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
    System.out.println(new _699_falling_squares().fallingSquares(positions));
  }

}
