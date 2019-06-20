package cracking_coding_interview.Recursion;

import leetcode.Printer;

public class _8_10_paintFill {
  public static void paintFill(int[][] screen, int x, int y, int color) {
    if (screen == null || x >= screen.length || x < 0 || y < 0 || y >= screen[0].length)
      throw new IllegalArgumentException();
    int targetColor = screen[x][y];
    fill(screen, x, y, color, targetColor);
  }

  private static void fill(int[][] screen, int x, int y, int color, int target) {
    if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length || screen[x][y] != target) return;
    screen[x][y] = color;
    fill(screen, x + 1, y, color, target);
    fill(screen, x - 1, y, color, target);
    fill(screen, x, y + 1, color, target);
    fill(screen, x, y - 1, color, target);
  }

  public static void main(String[] args) {
    int[][] image = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };

    int sr = 1, sc = 1, newColor = 2;
    paintFill(image, sr, sc, newColor);
    Printer.print(image);
  }
}
