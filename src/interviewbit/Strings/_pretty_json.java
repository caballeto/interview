package interviewbit.Strings;

import java.util.ArrayList;

public class _pretty_json {
  static final char INDENT = '\t';

  public static ArrayList<String> prettyJSON(String json) {
    int indent = 0;
    ArrayList<String> list = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < json.length(); i++) {
      char c = json.charAt(i);
      switch (c) {
        case '{': case '[': {
          builder.append(repeat(INDENT, indent));
          builder.append(c);
          list.add(builder.toString());
          builder = new StringBuilder();
          indent++;
          if (!(i != json.length() - 1 && (json.charAt(i + 1) == '{' || json.charAt(i + 1) == '[')))
            builder.append(repeat(INDENT, indent));
          break;
        }
        case ',': {
          builder.append(',');
          list.add(builder.toString());
          builder = new StringBuilder();
          if (!(i != json.length() - 1 && (json.charAt(i + 1) == '{' || json.charAt(i + 1) == '[')))
            builder.append(repeat(INDENT, indent));
          break;
        }
        case '}': case ']': {
          list.add(builder.toString());
          builder = new StringBuilder();
          indent--;
          builder.append(repeat(INDENT, indent));
          builder.append(c);
          break;
        }
        case ':': {
          builder.append(':');
          if (i != json.length() - 1 && (json.charAt(i + 1) == '[' || json.charAt(i + 1) == '{')) {
            list.add(builder.toString());
            builder = new StringBuilder();
          }
          break;
        }
        default: builder.append(c); break;
      }
    }

    list.add(builder.toString());
    return list;
  }

  private static String repeat(char c, int count) {
    StringBuilder builder = new StringBuilder(count);
    for (int i = 0; i < count; i++) builder.append(c);
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(prettyJSON("\"{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}"));

    for (String s : prettyJSON("\"{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}")) {
      System.out.println(s);
    }
  }
}
