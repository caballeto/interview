package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _max_nonneg_subarray {
  public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
    long sum = 0, prevSum = Long.MIN_VALUE;
    int start = 0, len = 0;
    int prevStart = Integer.MAX_VALUE, prevLen = Integer.MIN_VALUE;
    int elem;
    for (int i = 0; i < a.size() + 1; i++) {
      if (i < a.size()) elem = a.get(i);
      else elem = -1;
      if (elem >= 0) {
        sum += elem;
        len++;
      } else {
        if (sum > prevSum) {
          prevSum = sum;
          prevLen = len;
          prevStart = start;
        } else if (sum == prevSum) {
          if (len > prevLen) {
            prevSum = sum;
            prevLen = len;
            prevStart = start;
          } else if (len == prevLen) {
            if (start <= prevStart) {
              prevSum = sum;
              prevLen = len;
              prevStart = start;
            }
          }
        }

        sum = 0;
        start = i + 1;
        len = 0;
      }
    }

    ArrayList<Integer> subarray = new ArrayList<>();
    for (int i = prevStart; i < prevStart + prevLen; i++)
      subarray.add(a.get(i));
    return subarray;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
    System.out.println(maxset(list));
  }
}
