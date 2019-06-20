package cracking_coding_interview.Moderate;

public class _16_1_numberSwapper {
  public static int[] swap(Integer a, Integer b) {
    a += b;
    b = -(b - a);
    a -= b;
    return new int[]{a, b};
  }

  public static void main(String[] args) {
    int a = 5, b = 9;
    System.out.println(a + " " + b);
    var arr = swap(a, b);
    a = arr[0]; b = arr[1];
    System.out.println(a + " " + b);
  }
}
