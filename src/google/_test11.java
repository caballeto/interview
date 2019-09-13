package google;

import java.util.Arrays;

public class _test11 {
  // Time: O(M*log(M) + N*log(M)) = O((N + M)*log(M))
  // Space: O(N + M)
  static int[] solution(String A, String B) {
    if (A == null || B == null) throw new IllegalArgumentException("passed string is null");
    String[] MStrings = A.split(","), NStrings = B.split(",");
    int[] MFrequencies = calcFrequency(MStrings), NFrequencies = calcFrequency(NStrings); // calculate frequencies O(N + M)

    Arrays.sort(MFrequencies);// O(M*log(M))

    int[] result = new int[NStrings.length];
    for (int i = 0; i < NFrequencies.length; i++) { // O(N*log(M))
      int pos = Arrays.binarySearch(MFrequencies, NFrequencies[i]);
      pos = (pos < 0) ? -1 - pos : pos;
      result[i] = pos;
    }

    return result;
  }

  private static int[] calcFrequency(String[] strings) {
    int[] freqs = new int[strings.length];
    for (int i = 0; i < strings.length; i++)
      freqs[i] = findMinFrequency(strings[i]);
    return freqs;
  }

  private static int findMinFrequency(String s) {
    int[] counts = new int[26];
    char min = 'z';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      counts[c - 'a']++;
      if ((int) min > (int) c)
        min = c;
    }

    return counts[min - 'a'];
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("abcd,aabc,bd",  "aaa,aa")));
  }
}
