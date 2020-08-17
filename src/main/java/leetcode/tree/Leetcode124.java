package leetcode.tree;

public class Leetcode124 {

    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        gain_max(root);
        return maxPath;
    }

    private int gain_max(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = gain_max(root.left);
        int rightMax = gain_max(root.right);
        int maxSub = Math.max(leftMax, rightMax);

        int currPath = maxSub + root.val;
        maxPath = Math.max(maxPath, currPath);

        return currPath;
    }

}
