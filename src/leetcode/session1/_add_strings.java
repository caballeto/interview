package leetcode.session1;

public class _add_strings {
  public static String addStrings(String num1, String num2) {
    int sum = 0, carry = 0;
    int len1 = num1.length(), len2 = num2.length();

    StringBuilder sb = new StringBuilder();

    while (len1 >= 0 || len2 >= 0) {
      sum = carry;
      if (len1 >= 0) sum += num1.charAt(len1--) - '0';
      if (len2 >= 0) sum += num2.charAt(len2--) - '0';
      sb.append(sum % 10);
      carry = sum / 10;
    }

    if (carry != 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(addStrings("1230", "877"));
  }
}
