package interviewbit.Arrays;

import java.util.ArrayList;

public class _pascal_row {
  public static ArrayList<Integer> getRow(int k) {
    ArrayList<Integer> prevRow = new ArrayList<>(), newRow;
    prevRow.add(1);

    for (int row = 1; row < k + 1; row++) {
      newRow = new ArrayList<>();
      for (int i = 0; i <= prevRow.size(); i++) {
        if (i == 0 || i == prevRow.size()) {
          newRow.add(1);
        } else {
          newRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
      }

      prevRow = newRow;
    }

    return prevRow;
  }

  public static void main(String[] args) {
    System.out.println(getRow(3));
  }
}
