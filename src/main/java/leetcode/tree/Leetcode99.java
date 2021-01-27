package leetcode.tree;

import java.util.Stack;

public class Leetcode99 {

    /*
    //x,y 代表两个交换节点
    private Integer x, y;

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //1.利用中序遍历升序的特性获取错误结构的中序遍历顺序
        inOrder(root, list);
        //2.根据中序遍历前面节点大于后面节点的异常情况来定位两个错误节点的值
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                } else {
                    break;
                }
            }
        }
        //3.进行前序遍历在遍历过程中判断是否为错误节点,通过值来判断找到错误节点,并对节点赋正确值
        recoverInOrder(root);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    private void recoverInOrder(TreeNode root) {
        if (root != null) {
            recoverInOrder(root.left);
            if (root.val == x) {
                root.val = y;
            } else if (root.val == y) {
                root.val = x;
                return;
            }
            recoverInOrder(root.right);
        }
    }
*/

    //x,y 代表两个交换节点
    private TreeNode x, y;
    private TreeNode pred;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    return;
                }
            }
            pred = root;
            inOrder(root.right);
        }
    }

    public void recoverTree2(TreeNode root) {
        //有序的数,两个不正常的节点交换
        //那么不正常的2个节点
        //如     1 2 3 4 5 6 7 8 9
        //交换后 1 2 7 4 5 6 3 8 9
        //或者   1 2 3 5 4 6 7 8 9 (这里5、4有问题)
        //可知按顺序遍历第一个不正常的组合的前一个,与第二个不正常的组合的后一个,进行交换就可以
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode preNode = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (preNode != null && preNode.val > curr.val) {
                if (firstNode == null) {
                    firstNode = preNode;
                }
                secondNode = curr;
            }
            preNode = curr;
            curr = curr.right;
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public static void main(String[] args) {
        Leetcode99 leetcode99 = new Leetcode99();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        node3.right = node2;

//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(2);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
        leetcode99.recoverTree2(node1);
    }

}
