package interviewbit.Stacks;

import java.util.ArrayList;
import java.util.List;

public class _redundant_brace {
  public static int braces(String s) {
    List<Boolean> bool = new ArrayList<>();
    boolean expr = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      switch (c) {
        case '(': bool.add(expr); expr = false; break;
        case ')': {
          if (!expr) return 1;
          expr = bool.remove(bool.size() - 1);
          break;
        }
        case '+': case '-': case '*': case '/': expr = true; break;
        default: break;
      }
    }

    return 0;
  }
}
