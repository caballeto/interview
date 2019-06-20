package cracking_coding_interview.Hard;

public class _17_1_addPlus {
  public static int plus(int a, int b) {
    int c = a ^ b; // xor a and b
    int d = c | b; // add all (10, 01) cases
    int e = c ^ d; // get 11 cases
    if (e == 0) return d; // check if no 11 cases found
    return plus(c, e << 1); // move 11 cases further
  }

  public static void main(String[] args) {
    System.out.println(plus(9999, 1));
    System.out.println(plus(10245, -10245));
    System.out.println(plus(10245, -245));
    System.out.println(plus(Integer.MAX_VALUE, Integer.MIN_VALUE));
    System.out.println(plus(128, -128));
  }
}
