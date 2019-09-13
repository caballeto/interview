package leetcode.session1;

public class _longest_k_substring {
  public int longestSubstring(String s, int k) {
    char[] str = s.toCharArray();
    return solve(str, 0, s.length(), k);
  }

  private int solve(char[] str, int start, int end, int k) {
    if (end - start < k) return 0;
    int[] count = new int[26];
    for (int i = start; i < end; i++)
      count[str[i] - 'a']++;
    for (int i = 0; i < 26; i++) {
      if (count[i] < k && count[i] > 0) {
        for (int j = start; j < end; j++) {
          if (str[j] == i + 'a') {
            int left = solve(str, start, j, k);
            int right = solve(str, j + 1, end, k);
            return Math.max(left, right);
          }
        }
      }
    }

    return end - start;
  }
}
