package interviewbit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class _numbers_length {
  public static int solve(ArrayList<Integer> nums, int b, int c) {
    if (b == 0) return 0;
    String s = "" + c;
    int sum = 0;
    for (int i = 0; i < nums.size(); i++) {
      int val = nums.get(i);
      if (val == 0) {
        sum += (b == 1) ? 1 : 0;
        continue;
      }

      int first = s.charAt(0) - '0';
      if (val < first && s.length() >= b) {
        sum += (b == 1) ? 1 : nums.size();
      } else if (val == first) {
        if (s.length() > 1) {
          sum += 1;
        } else {
          nums.remove(i);
          sum += solve(nums, b - 1, Integer.parseInt(s.substring(1)));
          nums.add(i, val);
        }
      } else {
        if (b == 1) {
           sum += (val < c) ? 1 : 0;
        }
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 5)); // 0 2 5
    System.out.println(solve(list, 2, 21));
  }
}
