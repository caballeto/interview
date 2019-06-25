package interviewbit.Hashing;

import java.util.HashMap;
// AWFUL TASK
// https://github.com/delnaz/InterviewBit/blob/master/InterviewBit/src/com/interviewbit/linkedlistandhashing/Fraction.java
public class _fractional {
  public static String fractionToDecimal(long num, long den) {
    if (num == 0) return "0";
    if (den == 0) return "";

    String val = "";
    HashMap<Long, Integer> map = new HashMap<>();
    if ((num < 0) ^ (den < 0)) val += "-";
    long res = Math.abs(num) / Math.abs(den);
    val += "" + res;

    long rest = (Math.abs(num) % Math.abs(den)) * 10;
    if (rest == 0) return val;
    String part = "";
    while (rest != 0) {
      if (map.containsKey(rest)) {
        int index = map.get(rest);
        part = part.substring(0, index) + "(" + part.substring(index) + ")";
        break;
      }
      map.put(rest, part.length());
      res = rest / Math.abs(den);
      part += "" + res;
      rest = (rest % Math.abs(den)) * 10;
    }

    return val + "." + part;
  }

  // works fine, but not accepted
  public static void main(String[] args) {
    System.out.println(fractionToDecimal(-1, -2147483648).equals("0.0000000004656612873077392578125"));
    System.out.println(fractionToDecimal(1, 2147483640).equals("0.000(000000465661289042462740251655654056577585848337359161441621040707904997124914069194026549138227660723878669455195477065427143370461252966751355553982241280310754777158628319049732085502639731402098131932683780538602845887105337854867197032523144157689601770377165713821223802198558308923834223016478952081795603341592860749337303449725)"));
  }
}
