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



//    int max = Integer.MIN_VALUE;
//    public int maxPathSum(TreeNode root) {
//        maxNodeNum(root);
//        return max;
//    }
//
//    private int maxNodeNum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftMax = maxNodeNum(root.left);
//        int rightMax = maxNodeNum(root.right);
//
//        if (leftMax > 0 && rightMax > 0) {
//            if (max < leftMax + rightMax + root.val) {
//                max = leftMax + rightMax + root.val;
//            }
//
//            return Math.max(leftMax + root.val, rightMax + root.val);
//        }
//
//        if (leftMax > 0) {
//            if (max < leftMax + root.val) {
//                max = leftMax + root.val;
//            }
//
//            return leftMax + root.val;
//        }
//
//        if (rightMax > 0) {
//            if (max < rightMax + root.val) {
//                max = rightMax + root.val;
//            }
//
//            return rightMax + root.val;
//        }
//
//        if (max < root.val) {
//            max = root.val;
//        }
//
//        return root.val;
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Leetcode124 leetcode124 = new Leetcode124();
        leetcode124.maxPathSum(root);

    }

}
