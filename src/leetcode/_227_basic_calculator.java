package leetcode;

public class _227_basic_calculator {
  public int calculate(String s) {
    int idx = 0, sum = 0, pre = 0;
    s = s.replaceAll(" ", "");
    while(idx < s.length()) {
      int start = idx++;
      while(idx < s.length() && Character.isDigit(s.charAt(idx))) idx++;
      int v = Integer.valueOf(s.substring(Character.isDigit(s.charAt(start))? start : start + 1, idx));
      if(s.charAt(start) == '-') v = -v;
      if(s.charAt(start) == '/' || s.charAt(start) == '*') {
        sum -= pre;
        if(s.charAt(start) == '/') pre /= v;
        if(s.charAt(start) == '*') pre *= v;
      } else {
        pre = v;
      }

      sum += pre;
    }
    return sum;
  }

  public static void main(String[] args) {
    String expr = "100000000/1/2/3/4/5/6/7/8/9/10";
    System.out.println(new _227_basic_calculator().calculate(expr));
  }
}
