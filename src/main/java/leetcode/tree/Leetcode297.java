package leetcode.tree;

import java.util.*;

public class Leetcode297 {

    /*
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        TreeNode curr;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nullSize = 0;
            for (int i = 0; i < size; i++) {
                curr = queue.remove();
                if (curr == null) {
                    queue.add(null);
                    queue.add(null);
                    list.add("null");
                    nullSize++;
                } else {
                    queue.add(curr.left);
                    queue.add(curr.right);
                    list.add(String.valueOf(curr.val));
                }
            }
            if (nullSize == size) {
                break;
            }
        }
        int k = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!"null".equals(list.get(i))) {
                k = i;
                break;
            }
        }
        for (int i = 0; i < k; i++) {
            sb.append(list.get(i)).append(",");
        }
        sb.append(list.get(k));
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        int size = data.length();
        String source = data.substring(1, size - 1);
        String[] list = source.split(",");
        Map<Integer, TreeNode> resMap = new HashMap<>();
        TreeNode root = null;
        int treeSize = list.length;
        if (treeSize > 0 && !"".equals(list[0])) {
            root = new TreeNode(Integer.parseInt(list[0]));
            resMap.put(0, root);
        } else {
            return null;
        }

        int i = 0;

        while (i < treeSize) {
            String str = list[i];
            if (!"null".equals(str)) {
                TreeNode curr = resMap.get(i);
                int offset = 2 * (i + 1) - 1;
                //左子节点
                if (offset < treeSize) {
                    if (!"null".equals(list[offset])) {
                        TreeNode left = new TreeNode(Integer.parseInt(list[offset]));
                        curr.left = left;
                        resMap.put(offset, left);
                    }
                    //右子节点
                    if (offset + 1 < treeSize) {
                        if (!"null".equals(list[offset + 1])) {
                            TreeNode right = new TreeNode(Integer.parseInt(list[offset + 1]));
                            curr.right = right;
                            resMap.put(offset + 1, right);
                        }
                    }
                }
            }
            i++;
        }
        return root;
    }
     */

    /*
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> list = new ArrayList<>();
        rserialize(list, root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(",");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }

    //递归序列化
    private void rserialize(List<String> list, TreeNode root) {
        if (root == null) {
            list.add("null");
        } else {
            list.add(String.valueOf(root.val));
            rserialize(list, root.left);
            rserialize(list, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] arr = data.split(",");
        List<String> res = new LinkedList<>(Arrays.asList(arr));
        TreeNode root = rdeserialize(res);
        return root;
    }

    private TreeNode rdeserialize(List<String> res) {
        if ("null".equals(res.get(0))) {
            res.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(res.get(0)));
        res.remove(0);
        root.left = rdeserialize(res);
        root.right = rdeserialize(res);
        return root;
    }

     */

    /**
     *     1
     *   2   5
     * 3   4
     */

    /*
    public String serialize(TreeNode root) {
        //tree: [v1,v2,null,...]
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if(cur == null){
                res.append("null,");
            }else{
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length()-1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList();
        TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++){
            TreeNode cur = getNode(nodes[i]);
            if(isLeft){
                parent.left = cur;
            }else{
                parent.right = cur;
            }
            if(cur != null){
                parents.add(cur);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val){
        if(val.equals("null")){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            sb.append(root.val);
            TreeNode curr = null;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    curr = queue.remove();
                    sb.append(",");
                    if (curr.left != null) {
                        queue.add(curr.left);
                        sb.append(curr.left.val);
                    } else {
                        sb.append("null");
                    }

                    sb.append(",");
                    if (curr.right != null) {
                        queue.add(curr.right);
                        sb.append(curr.right.val);
                    } else {
                        sb.append("null");
                    }
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //每一个不为null的父节点一定对应着字符串中两个子节点,队列是层序遍历的顺序
        //队列前一个不为null的节点对应字符串前两个子节点,两个子节点结束后,那么队列下一个不为null的节点则必然对应字符串中前两个节点后的两个节点
        if ("[]".equals(data)) {
            return null;
        }
        String[] sub = data.substring(1, data.length() - 1).split(",");
        if (sub.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(sub[0]));
        queue.add(root);
        TreeNode last = null;
        TreeNode curr = null;
        int k = 1;
        while (!queue.isEmpty() && k <= sub.length) {
            last = queue.remove();
            if (!"null".equals(sub[k])) {
                curr = new TreeNode(Integer.parseInt(sub[k]));
                queue.add(curr);
                last.left = curr;
            }
            k++;
            if (k >= sub.length) {
                break;
            }
            if (!"null".equals(sub[k])) {
                curr = new TreeNode(Integer.parseInt(sub[k]));
                queue.add(curr);
                last.right = curr;
            }
            k++;
        }
        return root;
    }

    public static void main(String[] args) {
        Leetcode297 leetcode297 = new Leetcode297();
        System.out.println(leetcode297.serialize(leetcode297.deserialize("[]")));;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node5;
//        node2.left = node3;
//        node2.right = node4;
//        String str = leetcode297.serialize(node1);
//        System.out.println(str);
//        TreeNode root = leetcode297.deserialize(str);
//        System.out.println(root);


//        String str2 = leetcode297.serialize(root);
//        System.out.println(str2);
//
//        System.out.println("=========");
//        TreeNode test = leetcode297.deserialize("[1,2,3,null,null,4,5]");
//        System.out.println(test);
//        String res = leetcode297.serialize(null);
//        System.out.println(res);
    }

}
