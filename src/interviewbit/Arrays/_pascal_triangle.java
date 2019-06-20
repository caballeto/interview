package interviewbit.Arrays;

import java.util.ArrayList;

public class _pascal_triangle {
  public static ArrayList<ArrayList<Integer>> solve(int rows) {
    if (rows == 0) return new ArrayList<>();
    ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
    ArrayList<Integer> prevRow = new ArrayList<>(), newRow;
    pascal.add(prevRow);
    prevRow.add(1);

    for (int row  = 1; row < rows; row++) {
      newRow = new ArrayList<>();
      for (int i = 0; i <= prevRow.size(); i++) {
        if (i == 0 || i == prevRow.size()) {
          newRow.add(1);
        } else {
          newRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
      }

      pascal.add(newRow);
      prevRow = newRow;
    }

    return pascal;
  }

  public static void main(String[] args) {
    System.out.println(solve(7));
  }
}
