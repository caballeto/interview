package cracking_coding_interview.Graphs;

public class _4_2_minimalTree {
  public static TreeNode minimalTree(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    return add(nums, 0, nums.length - 1);
  }

  private static TreeNode add(int[] nums, int lo, int hi) {
    if (hi < lo) return null;
    TreeNode node = new TreeNode();
    int mid = (lo + hi) / 2;
    node.val = nums[mid];
    node.left = add(nums, lo, mid - 1);
    node.right = add(nums, mid + 1, hi);
    return node;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5}; // 3 1 4 2 null 5 null
    TreeNode node = minimalTree(nums);
    System.out.println(node.val);
    System.out.println(node.left.val);
    System.out.println(node.right.val);
  }
}
