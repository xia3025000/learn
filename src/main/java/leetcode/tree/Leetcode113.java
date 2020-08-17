package leetcode.tree;

import java.util.*;

public class Leetcode113 {
    //深度优先搜索迭代
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        Map<TreeNode, TreeNode> routeMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root, root.val);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int currSum = map.get(curr);
            if (curr.left == null && curr.right == null) {
                if (currSum == sum) {
                    Stack<Integer> oneStack = new Stack<>();
                    oneStack.push(curr.val);
                    TreeNode last = routeMap.get(curr);
                    while (last != null) {
                        oneStack.push(last.val);
                        last = routeMap.get(last);
                    }
                    List<Integer> list = new ArrayList<>();
                    while (!oneStack.isEmpty()) {
                        list.add(oneStack.pop());
                    }
                    res.add(list);
                }
            }
            if (curr.right != null) {
                stack.push(curr.right);
                routeMap.put(curr.right, curr);
                map.put(curr.right, currSum + curr.right.val);
            }
            if (curr.left != null) {
                stack.push(curr.left);
                routeMap.put(curr.left, curr);
                map.put(curr.left, currSum + curr.left.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode113 leetcode113 = new Leetcode113();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        List<List<Integer>> list = leetcode113.pathSum(node1, 22);
        System.out.println(list);
    }

}
