package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class _stepping_numbers {
  public static ArrayList<Integer> stepnum(int start, int end) {
    int minlen = String.valueOf(start).length(), maxlen = String.valueOf(end).length();
    ArrayList<Integer> nums = new ArrayList<>();
    for (int len = minlen; len <= maxlen; len++)
      nums.addAll(stepnum(len));

    ArrayList<Integer> result = new ArrayList<>();
    for (int val : nums) {
      if (val >= start && val <= end) {
        result.add(val);
      }
    }

    if (start <= 0) result.add(0);
    Collections.sort(result);
    return result;
  }

  private static ArrayList<Integer> stepnum(int len) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      solve(list, String.valueOf(i), 1, len);
    }

    return list;
  }

  private static void solve(ArrayList<Integer> list, String num, int index, int length) {
    if (index == length) {
      list.add(Integer.parseInt(num));
    } else {
      char c = num.charAt(num.length() - 1);
      if (c == '9') {
        solve(list, num + "8", index + 1, length);
      } else if (c == '0') {
        solve(list, num + "1", index + 1, length);
      } else {
        solve(list, num + ((char) (c + 1)), index + 1, length);
        solve(list, num + ((char) (c - 1)), index + 1, length);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(stepnum(10, 20));
  }
}
