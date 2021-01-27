package leetcode.tree;

public class Leetcode111 {
    Integer min = null;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root, 1);
        return min;
    }

    private void traversal(TreeNode root, int level) {
        if (root != null) {
            traversal(root.left, level + 1);
            traversal(root.right, level + 1);
        } else {
            if (min == null) {
                min = level;
            }
            min = Math.min(min, level);
        }
    }

    public static void main(String[] args) {
        Leetcode111 leetcode111 = new Leetcode111();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        leetcode111.minDepth(node1);
    }

}
