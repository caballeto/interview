package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _301_remove_valid_par {
  private Set<String> valid = new HashSet<>();

  private void recurse(String s, int index, int leftCount, int rightCount, int left, int right, StringBuilder expr) {
    if (index == s.length()) {
      if (left == 0 && right == 0) valid.add(expr.toString());
    } else {
      char c = s.charAt(index);
      int len = expr.length();

      if ((c == '(' && left > 0) || (c == ')' && right > 0)) {
        recurse(s, index + 1, leftCount, rightCount, left - (c == '(' ? 1 : 0), right - (c == ')' ? 1 : 0), expr);
      }

      expr.append(c);

      if (c != '(' && c != ')') {
        recurse(s, index + 1, leftCount, rightCount, left, right, expr);
      } else if (c == '(') {
        recurse(s, index + 1, leftCount + 1, rightCount, left, right, expr);
      } else if (rightCount < leftCount) {
        recurse(s, index + 1, leftCount, rightCount + 1, left, right, expr);
      }

      expr.deleteCharAt(len);
    }
  }

  public List<String> removeInvalidParentheses(String s) {
    int left = 0, right = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else if (s.charAt(i) == ')') {
        right = (left == 0) ? right + 1 : right;
        left = (left > 0) ? left - 1 : left;
      }
    }

    recurse(s, 0, 0, 0, left, right, new StringBuilder());
    return new ArrayList<>(valid);
  }
}
