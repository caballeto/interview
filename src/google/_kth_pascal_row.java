package google;

import java.util.ArrayList;
import java.util.Arrays;

public class _kth_pascal_row {
  public static ArrayList<Integer> getRow(int rows) {
    if (rows == 0) return new ArrayList<>(Arrays.asList(1));
    ArrayList<Integer> current = null, prev = new ArrayList<>(Arrays.asList(1));

    for (int i = 0; i < rows; i++) {
      current = new ArrayList<>();
      current.add(1);
      for (int j = 1; j < i + 1; j++) {
        current.add(prev.get(j) + prev.get(j - 1));
      }

      current.add(1);
      prev = current;
    }

    return current;
  }
}
