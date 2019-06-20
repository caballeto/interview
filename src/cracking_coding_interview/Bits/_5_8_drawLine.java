package cracking_coding_interview.Bits;

public class _5_8_drawLine {
  public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
    int height = screen.length / width;
    if (x1 < 0 || x2 < 0 || x1 >= width*8 || x2 >= width*8 || x1 > x2 || y < 0 || y >= height)
      throw new IllegalArgumentException();

    for (int i = x1; i <= x2; i++) {
      int start = y*width + i / 8;
      screen[start] |= (1 << (7 - i % 8));
    }
  }

  public static void main(String[] args) {
    byte[] screen = {0, 0, 0, 0, 0, 0};
    int width = 3, y = 1, x1 = 5, x2 = 16;
    drawLine(screen, width, x1, x2, y);
    for (var b : screen) {
      System.out.println(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
    }
  }
}
