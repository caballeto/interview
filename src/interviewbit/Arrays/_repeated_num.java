package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _repeated_num {
  public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
    int[] nums = new int[A.size()];
    for (int num : A) {
      nums[num - 1]++;
    }
    int a = -1, b = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) b = i + 1;
      if (nums[i] == 2) a = i + 1;
    }

    ArrayList<Integer> l = new ArrayList<>();
    l.add(a);
    l.add(b);
    return l;
  }

  public static void main(String[] args) {
    System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(3, 1, 2, 5, 3))));
  }
}
