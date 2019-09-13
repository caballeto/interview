package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _letter_phone_combination {
  private static List<String> result;
  private static HashMap<Character, String> map;

  public static List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return new ArrayList<>();
   map = new HashMap<>();

    map.put('2',"abc");
    map.put('3',"def");
    map.put('4',"ghi");
    map.put('5',"jkl");
    map.put('6',"mno");
    map.put('7',"pqrs");
    map.put('8',"tuv");
    map.put('9',"wxyz");

    char[] array = digits.toCharArray();
    backtrack(0, array.length - 1, "", array);
    return result;
  }

  private static void backtrack(int lo, int hi, String s, char[] array) {
    if (lo > hi) {
      result.add(s);
      return;
    }

    String keys = map.get(array[lo]);
    for (char c : keys.toCharArray()) {
      backtrack(lo + 1, hi, s + c, array);
    }
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
}
