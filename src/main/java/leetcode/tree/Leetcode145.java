package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisit = null;
        TreeNode curr = root;
        boolean isOut = false;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null && isOut == false) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            isOut = false;
            if (curr.right == null || curr.right == lastVisit) {
                list.add(root.val);
                lastVisit = curr;
                isOut = true;
                if (curr == root) {
                    break;
                }
            } else {
                stack.push(curr);
            }
            curr = curr.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode145 leetcode145 = new Leetcode145();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        leetcode145.postorderTraversal(node1);
    }
}
