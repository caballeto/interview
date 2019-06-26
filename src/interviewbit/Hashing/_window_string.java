package interviewbit.Hashing;

public class _window_string {
  public static String minWindow(String s, String t) {
    char[] target = new char[256];
    for (int i = 0; i < t.length(); i++)
      target[t.charAt(i)]++;

    char[] chars = new char[256];
    int offset = 0, minLen = s.length() + 1, count = 0;
    String val = "";
    for  (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (target[c] != 0) {
        if (chars[c] == 0) {
          chars[c] = 1;
          count++;
        } else {
          if (chars[c] < target[c])
            count++;
          chars[c]++;
        }
      }

      if (count == t.length()) {
        char ch = s.charAt(offset);
        while (chars[ch] == 0 || chars[ch] > target[ch]) {
          if (chars[ch] != 0 && chars[ch] > target[ch])
            chars[ch]--;
          offset++;
          ch = s.charAt(offset);
        }

        if (i - offset + 1 < minLen) {
          val = s.substring(offset, i + 1);
          minLen = i - offset + 1;
        }
      }
    }

    return val;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
}
