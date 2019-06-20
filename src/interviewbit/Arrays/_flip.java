package interviewbit.Arrays;

import java.util.ArrayList;

public class _flip {
  public static ArrayList<Integer> flip(String a) {
    int[] sums = new int[a.length() + 1];
    int total = 0;
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (c == '1') {
        sums[i + 1] = 0;
      } else {
        total++;
        sums[i + 1] = sums[i] + 1;
      }
    }

    if (total == 0) return new ArrayList<>();

    int maxIndex = -1, maxVal = Integer.MIN_VALUE, zindex = -1;
    for (int i = 1; i < sums.length; i++) {
      if (sums[i] >= maxVal) {
        maxVal = sums[i];
        maxIndex = i;
      }
    }

    sums[maxIndex] = 0;
    for (int i = maxIndex; i > 0; i--) {
      sums[i - 1] = sums[i] + ((a.charAt(i - 1) == '1') ? -1 : 1);
    }

    zindex = maxIndex;
    for (int i = maxIndex; i >= 0; i--) {
      if (sums[i] >= sums[zindex]) {
        zindex = i;
      }
    }

    ArrayList<Integer> list = new ArrayList<>();
    list.add(zindex + 1);
    list.add(maxIndex);
    return list;
  }

  public static void main(String[] args) {
    //String a = "00001111111";
    //String a = "1010101";
    //String a = "1101010001";
    String a = "0111000100010";
    System.out.println(flip(a));
  }
}
