package leetcode;

public class _258_add_digits {
  public int addDigits(int num) {
    if (num / 10 == 0) return num;
    int sum = 0;
    while (num != 0) {
      sum += num % 10;
      num /= 10;
    }

    return addDigits(sum);
  }

  public static void main(String[] args) {
    int num = 258;
    System.out.println(new _258_add_digits().addDigits(num));
  }
}
