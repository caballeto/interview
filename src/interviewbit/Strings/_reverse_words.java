package interviewbit.Strings;

public class _reverse_words {
  public String reverseWords(String s) {
    String[] parts = s.trim().split(" ");
    reverse(parts);
    return String.join(" ", parts);
  }

  private static void reverse(String[] array) {
    for (int i = 0; i < array.length/2; i++) {
      String temp = array[i];
      array[i] = array[array.length - i - 1];
      array[array.length - i - 1] = temp;
    }
  }
}
