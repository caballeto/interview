package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _71_simple_path {
  public String simplifyPath(String path) {
    path = cleanPath(path);
    if (path == null)
      throw new IllegalArgumentException();

    String[] parts = path.split("/");
    List<String> stack = new ArrayList<>();

    for (String part : parts) {
      if (part.equals(".")) {
        continue;
      } else if (part.equals("..")) {
        if (!stack.isEmpty())
          stack.remove(stack.size() - 1);
      } else {
        stack.add(part);
      }
    }

    StringBuilder builder = new StringBuilder("/");
    for (int i = 0; i < stack.size(); i++) {
      builder.append(stack.get(i));
      if (i != stack.size() - 1)
        builder.append('/');
    }

    return builder.toString();
  }

  private String cleanPath(String path) {
    path = path.replaceAll("/+", "/");
    if (path.equals("/")) return path;
    int last = path.length() - 1;
    if (path.charAt(0) == '/' && path.charAt(last) == '/') {
      return path.substring(1, last);
    } else if (path.charAt(0) == '/') {
      return path.substring(1);
    } else if (path.charAt(last) == '/') {
      return path.substring(0, last);
    }

    return null;
  }

  public static void main(String[] args) {
    String path = "/";
    System.out.println(new _71_simple_path().simplifyPath(path));
  }
}
