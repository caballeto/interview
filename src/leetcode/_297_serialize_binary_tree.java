package leetcode;

public class _297_serialize_binary_tree {
  private Integer index;

  public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder builder = new StringBuilder();
    builder.append(Integer.valueOf(root.val).toString());
    serialize(root, builder);
    return builder.toString();
  }

  private void serialize(TreeNode node, StringBuilder builder) {
    if (node.left != null) {
      builder.append(',');
      builder.append(Integer.valueOf(node.left.val).toString());
    } else {
      builder.append(",null");
    }

    if (node.right != null) {
      builder.append(',');
      builder.append(Integer.valueOf(node.right.val).toString());
    } else {
      builder.append(",null");
    }

    if (node.left  != null) serialize(node.left, builder);
    if (node.right != null) serialize(node.right, builder);
  }

  public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    String[] parts = data.split(",");
    TreeNode root = new TreeNode(Integer.valueOf(parts[0]));
    index = 1;
    deserialize(root, parts);
    return root;
  }

  private void deserialize(TreeNode node, String[] parts) {
    if (parts[index].equals("null")) {
      node.left = null;
    } else {
      node.left = new TreeNode(Integer.valueOf(parts[index]));
    }

    if (parts[index + 1].equals("null")) {
      node.right = null;
    } else {
      node.right = new TreeNode(Integer.valueOf(parts[index + 1]));
    }

    index += 2;
    if (node.left != null) deserialize(node.left, parts);
    if (node.right != null) deserialize(node.right, parts);
  }

  public static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    _297_serialize_binary_tree serializer = new _297_serialize_binary_tree();

    TreeNode node = serializer.deserialize(serializer.serialize(root));

    System.out.println(node.val);
    System.out.println(node.left.val);
    System.out.println(node.right.val);
    System.out.println(node.right.left.val);
    System.out.println(node.right.right.val);
  }
}
