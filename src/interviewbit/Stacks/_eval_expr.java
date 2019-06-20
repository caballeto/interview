package interviewbit.Stacks;

import java.util.ArrayList;
import java.util.List;

public class _eval_expr {
  public static int evalRPN(ArrayList<String> expr) {
    List<Integer> stack = new ArrayList<>();

    for (String s : expr) {
      if (s.equals("+")) {
        int val = stack.remove(stack.size() - 1);
        stack.add(stack.remove(stack.size() - 1) + val);
      } else if (s.equals("-")) {
        int val = stack.remove(stack.size() - 1);
        stack.add(stack.remove(stack.size() - 1) - val);
      } else if (s.equals("*")) {
        int val = stack.remove(stack.size() - 1);
        stack.add(stack.remove(stack.size() - 1) * val);
      } else if (s.equals("/")) {
        int val = stack.remove(stack.size() - 1);
        stack.add(stack.remove(stack.size() - 1) / val);
      } else {
        stack.add(Integer.parseInt(s));
      }
    }

    return stack.remove(0);
  }
}
