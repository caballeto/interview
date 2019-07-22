package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;

public class _sum_root_nums {
  private static ArrayList<Long> nums;

  public static int sumNumbers(TreeNode node) {
    nums = new ArrayList<>();
    solve(node, 0L);
    return sum(nums);
  }

  private static void solve(TreeNode node, long num) {
    num = (10*num + node.val) % 1003;
    if (node.left == null && node.right == null) {
      nums.add(num);
    } else if (node.left == null) {
      solve(node.right, num);
    } else if (node.right == null) {
      solve(node.left, num);
    } else {
      solve(node.left, num);
      solve(node.right, num);
    }
  }

  private static int sum(ArrayList<Long> nums) {
    long sum = 0;
    for (long num : nums) {
      sum = (sum + num) % 1003;
    }

    return (int) (sum % 1003);
  }
}
