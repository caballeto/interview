package interviewbit.Strings;

public class _int_roman {
  public static String intToRoman(int num) {
    if (num == 0) return "";
    int order = (int) (Math.log10(num) + 1), factor = (int) Math.pow(10, order - 1);
    StringBuilder builder = new StringBuilder();
    while (order > 0) {
      int val = num / factor, rest = num % factor;
      builder.append(toRoman(val, order));
      num = rest;
      order = (int) (Math.log10(num) + 1);
      factor = (int) Math.pow(10, order - 1);
    }

    return builder.toString();
  }

  private static String toRoman(int val, int order) {
    if (order == 1) {
      switch (val) {
        case 1: return "I";
        case 2: return "II";
        case 3: return "III";
        case 4: return "IV";
        case 5: return "V";
        case 6: return "VI";
        case 7: return "VII";
        case 8: return "VIII";
        case 9: return "IX";
      }
    } else if (order == 2) {
      switch (val) {
        case 1: return "X";
        case 2: return "XX";
        case 3: return "XXX";
        case 4: return "XL";
        case 5: return "L";
        case 6: return "LX";
        case 7: return "LXX";
        case 8: return "LXXX";
        case 9: return "XC";
      }
    } else if (order == 3) {
      switch (val) {
        case 1: return "C";
        case 2: return "CC";
        case 3: return "CCC";
        case 4: return "CD";
        case 5: return "D";
        case 6: return "DC";
        case 7: return "DCC";
        case 8: return "DCCC";
        case 9: return "CM";
      }
    } else if (order == 4) {
      switch (val) {
        case 1: return "M";
        case 2: return "MM";
        case 3: return "MMM";
      }
    }

    throw new RuntimeException();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(  789));
  }
}
