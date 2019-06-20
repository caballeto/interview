package interviewbit.Strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Works only locally
public class _stringoholics {
  private static final BigInteger FACTOR = BigInteger.valueOf(1000000007);

  public static int solve(ArrayList<String> list) {
    List<Integer> steps = new ArrayList<>();

    for (String s : list) {
      steps.add(step(s));
    }

    BigInteger val = BigInteger.valueOf(steps.get(0));
    for (int i = 1; i < list.size(); i++) {
      val = lcm(val, BigInteger.valueOf(steps.get(i)));
    }

    return val.mod(FACTOR).intValueExact();
  }

  private static BigInteger lcm(BigInteger a, BigInteger b) {
    return a.multiply(b).divide(a.gcd(b));
  }

  private static int step(String s) {
    int n = s.length();
    if (n == 1 || n == 0) return 1;
    int step = 0;
    for (int i = 1; i <= 2*n - 1; i++) {
      step += (i % n);
      if (step % n == 0 && step >= 1) {
        return i;
      }
    }

    System.out.println("asdsd");
    return -1;
  }

  private static long lcm(long a, long b) {
    long v = a / gcd(a, b);
    return v * b;
  }


  private static long gcd(long a, long b) {
    long temp = 0;

    while (b != 0) {
      temp = b;
      b = a % b;
      a = temp;
    }

    return a;
  }

  public static void main(String[] args) {
    System.out.println(solve(new ArrayList<>(Arrays.asList("baaaaaaabbaaababbababbabbabaaabaaaabaa", "bbaabbaabaabbb", "aaabaaabaababbabbbbbbabbbbbaaaaaaaaaaaababbababababaaaaabbabaabaabbbbbaaababbbbbbabbabbbbaab", "abbbaabbababbbbababbbaababaaabaaabbbbaabbabaaaabababaaaaaaaabaaaabbbabbbaaa", "aabaabbaaaaaaaaaaaaabbababbabbabbbbbbabbabbbbbbabbaaaaaab", "baabbbbabababbaaabbbbaaaaaaababaabbabaaaababbabbaabbabbbaabbabbaaaabbbbbaabbaababaabbb", "bbaabbbabaabbbaaaabbbaabbabaabbbabaaababbaaaabbababaaaababaaababaababbbbbabbbababbbbb", "bbababaaaaababababbabaaabbbababaabbaabaaba", "bbbaabaaaaaabaabbaabaaaaababaaabaababbabaabbab", "babaabababbbbabaabaaababbabbbaaaabbbbbabbbaabbbbbbbbabbaaabbabbbaaab", "aabbabbaaabbaaabbabbbaaaabaab", "abababbbbbaabaabbabbbabbaba", "abaaababababaabbabaabbbbbaababaaaaabbaabbaaabbbbbabababbbaabbabbbbaaaaabbabaabb", "bbbabbbababaaabbaaaaaabbabbaabbbabbbababbbbbaabaababbbabaaaabbbbab", "aaabbaa", "abbabaaabbbbabbaaaabbbbbbabaabaaaaaaaaaabbbbaaaaaab", "bbbabaabbabaababbabaaaaaaabaaaabbbbabbbaba", "aba", "ababbabbabaabbaaabbbaaabbbbbaa", "bbaaaabbaaa", "bbbbbbaabababaabaabbbabbaaabaaabbbabaabaaaaaaabbaaabaa", "bababbaabbbaabbaaaaaabbbbbabaabbaabbabababbaaaaaababababbaabaaababaaaababababbababaaaba", "baaaaabbbbbbababbbbaaaabbabbbbbbabbaaabbbbbbabbbaaaaaabbabbaaabababbaabbbabbbabbabbbbbab", "bbababbaaaaabaabbbababbbbaaab", "aabaaab", "abbbab", "aaabbbaaabbbabaababaabbbabbbbaabaaabbaababaa", "aaabbabbabbbaaaaabaababaaaabbaabababba", "b", "babbabbbbbbbabbbbbabbbbaaaaabbbaaaaabbaabbabababaaaaabaabaaaabbabbaaaaabba", "babaaaaaab", "abbabbbababaaaaabababbaabaaaaaba", "aaaabbbbabbaabaaaabbabbaabaaaabaababaaabbbbb", "bbbabbaaababbababbabaabaaa", "aabbbaabbbaabbaaabbaabbbbbbbbbabbbabababaababaaabaabbbbaaababbbbbaabbaabbabaaaabab", "babbbbabbbaaaaabbaabbaaaaaababbbababaaabaababbaaaabbaabaaabbbaabbbaababbbbaaaaaaaaaaabaabbbbb", "abbbbabaaabaaaabaabaabaabbbbaabbbaaaabbaaaaaaabbaababbabbbababa", "baababaabaaababbaaaaaabbabaaabbbbb", "baababaaa", "bbabbababaaabaaabbbbabbaabbabbaabbaabba", "aabbaabababbbaaaababbbaaaaabbbabbaaaabababbbbbbbaabbbbbbbaaabbaabaabaaaabbbbababbbaaaabbabab", "abbaaaaabaaaabbbbaabaababbaabbbbbabbbabaabaaabbabbbabaaabbbaaabbababbabbbaaabbabbbbabbbbaabba", "aaababbbaabaabaaabbbbbaaababaaaababbbaaabaabbaabbbabaababaabaaab", "baaababbbaababbabaabbbbbbaababaaababbbaabaaabbaabababaaabaabbabbbbabaaba", "babaabbabaabaaaaaabbbbabbbbabbaababbbaaaaaaaa", "abaaa", "babaaaababbbbababbbbb", "abbaaaaaabbbabbaabbbbaaabbbaaabababaabaabbbbabbaababbaba", "aababaaabaaaabbaaaabababbbabbbabbbabbabaabbaaaabbbabaaabaaabbaabbaababbaaabbbb", "aaababbbbbbabbaabbaabbbabababaabbbaba", "bbaabbabbbabbaaaaaababbbaaaaaabbbababb", "baaababaababbaaa", "babbaaababbabbbbbbbbabbbbabbabababaabaaaa", "ababababababaabbbabbbbaabaabaababbbabbbbaabbaaababbaabaa", "abbbabaaaabaaaaabbaaababaaaaaabbbbaaaaabbbbbbbbbbbbbababaabaaababbaaaabbbaaabbbaaabaaa", "aaaabbababbabbbaabaabbabbabaabbabababbbbaaaabbabbbaaaabaaaabbbbbbababbaabaabbaaabaaa", "aabaaaabbbbaabbbbbbbbabaabbbabbabaabaababaaabbbbbaaaababb", "abbbbbabaaababbabbababbabaaabbabababaaabbaabaaabbaabbabaababaaaaaabababaaabaababbaa", "abbabbbbabaaababbabaaaaaaabbbbababababbabbababaabbabbabbbab", "bbbbabbab", "babbbbabbbabababbbbababaababbbbabaaababbabaaaaabbbbaaababbbbaabbabbbaaaabbabbabba", "babaaabbbbbbababaabbaaababbbabbabaabbaaabbbaaabbababb", "abbbaabaaaaaabaaaaabaabbbaabbab", "bbaabbabaabaaaaaaababbbabaaaabbbabbbbb", "baabaabaaabababbbbbbbbabbaabbabaabbabaababbbabbbaababbbbbbaabbabbbbaabaabbababa", "bbbbbaaababbbbaababbbbbaabbbaaaabbbabbbababababaaabbbbabababbabbbabababaaaaaab", "abaaabaabbaabbbaabbbaaaaaabababbabbaababbba", "abaabbbbbbaaababbbabaaaabaaabaabbaaaababbabbbaaabaaaaaaaaaaaabbabbabbabaaabbabaabaaaaaaabaabbabbbaa", "abababaaaaaaaaaabab", "abbabbbbbbbbbaabbbbabaaaaaababbabbaaabbbbbaabbbaaaabaabbaaaabababbb", "baaabaaabbbbbb", "aaabaabbabaaabbbaababaaabbbbbaabaaabbbabba", "bbbbabaaaabaaabbbabaababaabbbbbababbbabbaaaabbbababaabbabbaaabbbbaaaaabbabbbbbaabbabaaaa", "aabbbbaabaabbbabbbaabababbbbbbabbbabaabaabbbbbaabaaabbbaaabbbbaaaabbaabaaaabaabbbbbaaaabababab", "abbbaaaaababbbaaabbabaaaabbabaabbbbbbbabaaa", "babbbbbbbb"))));
  }
}
