package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _largest_number {
  public static String largestNumber(final List<Integer> list) {
    List<String> strings = new ArrayList<>();
    for (Integer num : list) strings.add(num.toString());
    strings.sort(new SlowOrder().reversed());
    return truncateZero(String.join("", strings));
  }

  private static String truncateZero(String s) {
    int i = 0;
    while (i < s.length() - 1) {
      if (s.charAt(i) == '0') i++;
      else break;
    }

    return s.substring(i);
  }

  private static class SlowOrder implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      long n1 = Long.parseLong(o1 + o2), n2 = Long.parseLong(o2 + o1);
      if      (n1 - n2 > 0) return 1;
      else if (n1 - n2 < 0) return -1;
      else return 0;
    }
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));
    System.out.println(largestNumber(list));
  }
}
