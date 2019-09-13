package google;

import java.util.Arrays;

public class _test12 {

  // Time: O(n), as K <= N.
  // Space: O(K) for storing the result
  static Integer[] solution(Integer[] N, int K) {
    if (N == null) throw new IllegalArgumentException("passed array is null");
    if (N.length == K) return N;

    // as array elements are distinct largest subarray
    // is the subarray with the maximum first entry
    int max = N[0], maxIndex = 0;

    for (int i = 1; i <= N.length - K; i++) {
      if (N[i] > max) {
        max = N[i];
        maxIndex = i;
      }
    }

    Integer[] result = new Integer[K];
    System.arraycopy(N, maxIndex, result, 0, K);

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new Integer[]{1,4,3,2,5}, 4)));
  }
}
