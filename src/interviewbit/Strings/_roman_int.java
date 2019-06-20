package interviewbit.Strings;

public class _roman_int {
  public static int romanToInt(String s) {
    if (s.isEmpty()) return 0;
    int i = 0;
    int sum = 0;
    while (i < s.length()) {
      if (i == s.length() - 1) return sum + get(s.charAt(i));
      int val = get(s.charAt(i + 1)) - get(s.charAt(i));
      if (val > 0 && (val % 4 == 0 || val % 9 == 0)) {
        sum += val;
        i += 2;
      } else {
        sum += get(s.charAt(i++));
      }
    }

    return sum;
  }

  private static int get(char c) {
    switch (c) {
      case 'I': return 1;
      case 'V': return 5;
      case 'X': return 10;
      case 'L': return 50;
      case 'C': return 100;
      case 'D': return 500;
      case 'M': return 1000;
      default: return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("XIV"));
  }
}
