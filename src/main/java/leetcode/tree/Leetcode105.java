package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {

    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(0, preorder, inorder);
    }

    private TreeNode build(int k, int[] preorder, int[] inorder) {
        if (k >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[k]);

        if (inorder.length == 1) {
            return root;
        }

        int mid = preorder[k];
        //找到中序的根位置
        int i = 0;
        while (true) {
            if (mid == inorder[i]) {
                break;
            }
            i++;
        }

        if (i > 0) {
            int[] newLeftInOrder = new int[i];
            for (int j = 0; j < i; j++) {
                newLeftInOrder[j] = inorder[j];
            }
            //构建左子树的中序数组
            root.left = build(++k, preorder, newLeftInOrder);
        }
        if (i < inorder.length - 1) {
            int[] newRightInOrder = new int[inorder.length - i - 1];
            //构建右子树的中序数组
            for (int j = i + 1; j < inorder.length; j++) {
                newRightInOrder[j - i - 1] = inorder[j];
            }
            root.right = build(++k, preorder, newRightInOrder);
        }

        return root;
    }

     */

    Map<Integer, Integer> map = new HashMap<>();
    int k = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode build(int in_left, int in_right, int[] preorder, int[] inorder) {
        if (in_left > in_right) {
            return null;
        }

        TreeNode curr = new TreeNode(preorder[k]);

        //找到根节点在中序的位置
        int index = map.get(preorder[k]);
        k++;

        curr.left = build(in_left, index - 1, preorder, inorder);
        curr.right = build(index + 1, in_right, preorder, inorder);

        return curr;
    }


    public static void main(String[] args) {
        Leetcode105 leetcode105 = new Leetcode105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        leetcode105.buildTree(preorder, inorder);
    }

}
