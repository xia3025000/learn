package leetcode.tree;

import java.util.*;

public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                curr = queue.remove();
                list.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (level % 2 == 1) {
                Collections.reverse(list);
            }
            res.add(list);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode103 leetcode103 = new Leetcode103();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        leetcode103.zigzagLevelOrder(node1);
    }
}
