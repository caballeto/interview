package interviewbit.Strings;

import java.util.ArrayList;

public class _zig_zag {
  @SuppressWarnings("unchecked")
  public static String convert(String s, int rows) {
    if (rows == 1) return s;
    ArrayList<Character>[] list = (ArrayList<Character>[]) new ArrayList[rows];
    for (int i = 0; i < list.length; i++)
      list[i] = new ArrayList<>();
    boolean bot = true;
    int row = 0;
    for (int i = 0; i < s.length(); i++) {
      list[row].add(s.charAt(i));
      if (row == rows - 1) {
        row--;
        bot = false;
      } else if (row == 0) {
        row++;
        bot = true;
      } else if (bot) {
        row++;
      } else {
        row--;
      }
    }

    StringBuilder builder = new StringBuilder(s.length());
    for (ArrayList<Character> r : list) {
      for (char c : r) {
        builder.append(c);
      }
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS", 1));
  }
}
