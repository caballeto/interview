import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MiniminSwap {
  static class Pair {
    int first, second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public String toString() {
      return "(" + first + "," + second + ")";
    }
  }

  static int minimumSwaps(int[] array) {
    int n = array.length;
    List<Pair> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Pair(array[i], i));
    }

    list.sort(Comparator.comparingInt(a -> a.first));
    boolean[] marked = new boolean[n];
    int swaps = 0;

    for (int i = 0; i < n; i++) {
      if (marked[i] || list.get(i).second == i) continue;

      int cycleSize = 0;
      int j = i;
      while (!marked[j]) {
        marked[j] = true;
        j = list.get(j).second;
        cycleSize++;
      }

      if (cycleSize > 0)
        swaps += (cycleSize - 1);
    }

    return swaps;
  }

  public static void main(String[] args) {
    System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}));
  }
}
