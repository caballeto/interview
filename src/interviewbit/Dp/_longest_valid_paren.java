package interviewbit.Dp;

import java.util.ArrayList;

public class _longest_valid_paren {
  public static int longestValidParentheses(String s) {
    int len = s.length(), maxLen = 0, last = -1;
    if (len == 0 || len == 1) return 0;

    ArrayList<Integer> stack = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.add(i);
      } else {
        if (stack.isEmpty()) {
          last = i;
        } else {
          stack.remove(stack.size() - 1);
          if (stack.isEmpty())
            maxLen = Math.max(maxLen, i - last);
          else
            maxLen = Math.max(maxLen, i - stack.get(stack.size() - 1));
        }
      }
    }

    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses(")()())"));
  }
}
