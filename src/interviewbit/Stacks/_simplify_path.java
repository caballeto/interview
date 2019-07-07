package interviewbit.Stacks;

import java.util.ArrayList;
import java.util.List;

public class _simplify_path {
  public static String simplifyPath(String s) {
    List<String> stack = new ArrayList<>();
    String[] parts = s.split("/");

    for (String part : parts) {
      if (part.equals("..")) {
        if (!stack.isEmpty())
          stack.remove(stack.size() - 1);
      } else if (!part.equals(".") && !part.isEmpty()){
        stack.add(part);
      }
    }

    return "/" + String.join("/", stack);
  }
}
