package cracking_coding_interview.Recursion;

import java.util.Comparator;
import java.util.List;

public class _8_13_boxes {
  public static class Box {
    private static final Comparator<Box> COMPARATOR = new BoxComparator();

    private int width;
    private int height;
    private int depth;

    public Box(int width, int height, int depth) {
      this.depth = depth;
      this.height = height;
      this.width = width;
    }

    public boolean canBeAbove(Box box) {
      return this.depth > box.depth && this.width > box.width && this.height > box.height;
    }

    private static class BoxComparator implements Comparator<Box> {
      @Override
      public int compare(Box o1, Box o2) {
        return o2.height - o1.height;
      }
    }
  }

  public static int boxes(List<Box> boxes) {
    boxes.sort(Box.COMPARATOR);
    int maxHeight = 0;
    int[] map = new int[boxes.size()];
    for (int i = 0; i < boxes.size(); i++) {
      int height = boxes(boxes, i, map);
      maxHeight = Math.max(maxHeight, height);
    }
    return maxHeight;
  }

  private static int boxes(List<Box> boxes, int index, int[] map) {
    if (index < boxes.size() && map[index] > 0) return map[index];

    Box bot = boxes.get(index);
    int maxHeight = 0;
    for (int i = index + 1; i < boxes.size(); i++) {
      if (boxes.get(i).canBeAbove(bot)) {
        int height = boxes(boxes, i, map);
        maxHeight = Math.max(maxHeight, height);
      }
    }

    return map[index] = maxHeight + bot.height;
  }

  public static void main(String[] args) {

  }
}
