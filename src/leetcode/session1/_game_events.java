package leetcode.session1;

import java.util.*;

public class _game_events {
  private static final Map<String, Integer> EVENTS = new HashMap<>();

  static {
    EVENTS.put("G", 4);
    EVENTS.put("Y", 3);
    EVENTS.put("R", 2);
    EVENTS.put("S", 1);
  }

  public static String[] getEventsOrder(String team1, String team2, String[] events1, String[] events2) {
    List<List<String>> events = new ArrayList<>();
    add(events, team1, events1);
    add(events, team2, events2);

    events.sort((a, b) -> {
      String t1 = a.get(2), t2 = b.get(2);
      int comp = compareTime(t1, t2);
      if (comp != 0) return comp;

      comp = EVENTS.get(a.get(3)) - EVENTS.get(b.get(3));
      if (comp != 0) return comp;

      comp = a.get(0).compareTo(b.get(0));
      if (comp != 0) return comp;

      comp = a.get(1).compareTo(b.get(1));
      if (comp != 0) return comp;

      return a.get(4).compareTo(b.get(4));
    });

    String[] result = new String[events.size()];
    int i = 0;
    for (List<String> e : events)
      result[i++] = String.join(" ", e);
    return result;
  }

  private static int compareTime(String t1, String t2) {
    if (t1.contains("+") && t2.contains("+")) {
      return parse(t1) - parse(t2);
    } else if (t1.contains("+")) {
      int t = parse(t2);
      return compareHalves(t1, t);
    } else if (t2.contains("+")) {
      int t = parse(t1);
      return -compareHalves(t2, t);
    } else {
      return parse(t1) - parse(t2);
    }
  }

  private static int compareHalves(String half, int t) {
    if (half.charAt(0) == '4') {
      return t > 45 ? -1 : 1;
    } else {
      return 1;
    }
  }

  private static int parse(String s) {
    int i = 0, num = 0, numExtra = 0, mult = 10;
    boolean extra = false;
    while (i < s.length()) {
      if (s.charAt(i) == '+') {
        extra = true;
      } else {
        if (extra) {
          numExtra = numExtra * 10 + (s.charAt(i) - '0');
        } else {
          num = num * 10 + (s.charAt(i) - '0');
        }
      }
      i++;
    }

    return num + numExtra;
  }

  private static void add(List<List<String>> result, String team, String[] events) {
    for (String e : events) {
      String[] parts = e.split(" ");
      List<String> list = new ArrayList<>();
      list.add(team);
      Collections.addAll(list, parts);
      result.add(list);
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(getEventsOrder("EDC", "CDE",
      new String[]{"Name1 12 G", "FirstName 43 Y"},
      new String[]{"Name3 45+1 S SubName", "Name4 46 G"}
      )));
  }
}
