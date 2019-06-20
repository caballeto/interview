package cracking_coding_interview.Arrays;

public class _1_3_urlify {
  public static void urlify(char[] string, int length) {
    if (string == null || string.length == 0) return;
    int i = length - 1, j = string.length - 1;
    while (i >= 0) {
      if (string[i] == ' ') {
        string[j--] = '0';
        string[j--] = '2';
        string[j--] = '%';
      } else {
        string[j--] = string[i];
      }
      i--;
    }
  }

  public static void main(String[] args) {
    var string = "Mr John Smith    ".toCharArray();
    int length = 13;
    urlify(string, length);
    System.out.println(new String(string));
  }
}
