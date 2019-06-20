package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _max_abs {
  public static int maxArr(ArrayList<Integer> A) {
    int sumI = 0, sum = 0, n = A.size();
    for (int i = 0; i < n; i++) {
      sumI += i;
      sum += A.get(i);
    }

    sumI /= n;
    sum /= n;

    int index = indexOfMaxPoint(A, sumI, sum);
    int maxS = A.get(index), maxI = index, maxDist = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if (i == index) continue;
      int dist = Math.abs(A.get(i) - maxS) + Math.abs(i - maxI);
      maxDist = Math.max(maxDist, dist);
    }

    return maxDist;
  }

  private static int indexOfMaxPoint(ArrayList<Integer> list, int meanI, int mean) {
    int maxIndex = -1, maxDist = Integer.MIN_VALUE;

    for (int i = 0; i < list.size(); i++) {
      int dist = Math.abs(list.get(i) - mean) + Math.abs(i - meanI);
      if (dist > maxDist) {
        maxDist = dist;
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, -1));
    System.out.println(maxArr(list));
  }
}
