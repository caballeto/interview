package interviewbit.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class _justified_text {
  public static ArrayList<String> fullJustify(ArrayList<String> list, int length) {
    if (list.isEmpty()) return new ArrayList<>();
    ArrayList<ArrayList<String>> text = new ArrayList<>();
    ArrayList<String> line = new ArrayList<>();
    line.add(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      String s = list.get(i);
      if (size(line) + s.length() + 1 <= length) {
        line.add(s);
      } else {
        text.add(line);
        line = new ArrayList<>();
        line.add(s);
      }
    }

    if (!line.isEmpty()) text.add(line);
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < text.size(); i++) {
      result.add(justify(text.get(i), (i == text.size() - 1 || text.get(i).size() == 1), length));
    }

    return result;
  }

  private static String justify(ArrayList<String> line, boolean isLast, int length) {
    if (isLast) {
      return String.join(" ", line) + repeat(' ', length - size(line)); // + " ".repeat(length - size(line));
    }

    StringBuilder builder = new StringBuilder();
    int len = size(line), tabs = length - len;
    int perOne = tabs / (line.size() - 1), extra = tabs - perOne * (line.size() - 1);

    for (int i = 0; i < line.size() - 1; i++) {
      String word = line.get(i);
      builder.append(word);
      builder.append(' ');
      builder.append(repeat(' ', perOne));
      //builder.append(" ".repeat(perOne));
      if (extra != 0) {
        builder.append(' ');
        extra--;
      }
    }

    builder.append(line.get(line.size() - 1));

    return builder.toString();
  }

  private static int size(ArrayList<String> line) {
    int length = 0;
    for (String s : line)
      length += s.length();
    return length + (line.isEmpty() ? 0 : line.size() - 1);
  }

  private static String repeat(char c, int count) {
    StringBuilder builder = new StringBuilder(count);
    for (int i = 0; i < count; i++) builder.append(c);
    return builder.toString();
  }

  public static void main(String[] args) {
    ArrayList<String> text = new ArrayList<>(Arrays.asList("am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"));
    ArrayList<String> j = fullJustify(text, 14);
    System.out.println(j);

    for (String s : j) {
      System.out.println(s);
    }
  }
}
