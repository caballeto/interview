package interviewbit.Backtracking;

import java.util.ArrayList;

public class _generate_par {
  public static ArrayList<String> generateParenthesis(int n) {
    ArrayList<String> pars = new ArrayList<>();
    generate(pars, "", 0, 0, 0, n);
    return pars;
  }

  private static void generate(ArrayList<String> pars, String current, int open, int closed, int len, int n) {
    if (len == 2*n && open == closed) {
      pars.add(current);
    } else {
      if (open < n)
        generate(pars, current + "(", open + 1, closed, len + 1, n);
      if (closed < open)
        generate(pars, current + ")", open, closed + 1, len + 1, n);
    }
  }

  public static void main(String[] args) {
    System.out.println(generateParenthesis(3));
  }
}
