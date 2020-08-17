package leetcode.backtrack;

import java.util.*;

public class Leetcode401 {

    public List<String> readBinaryWatch(int num) {
        int[] sour = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backtrack(res, num, sour, stack, 0, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, int num, int[] sour, Stack<Integer> stack, int left, int right, int start) {
        if (stack.size() == num) {
            StringBuilder sb = new StringBuilder();
            sb.append(left);
            sb.append(":");
            if (right < 10) {
                sb.append("0");
            }
            sb.append(right);
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < sour.length; i++) {
            int leftSum = left;
            int rightSum = right;
            if (i < 4) {
                if (left + sour[i] >= 12) {
                    continue;
                }
                leftSum = left + sour[i];
            } else {
                if (right + sour[i] >= 60) {
                    continue;
                }
                rightSum = right + sour[i];
            }
            stack.push(i);
            backtrack(res, num, sour, stack, leftSum, rightSum, i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Leetcode401 leetcode401 = new Leetcode401();
        List<String> res = leetcode401.readBinaryWatch(4);
        System.out.println(res);
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] oneArr = o1.split(":");
                String[] twoArr = o2.split(":");
                int oneLeft = Integer.parseInt(oneArr[0]);
                int oneRight = Integer.parseInt(oneArr[1]);
                int twoLeft = Integer.parseInt(twoArr[0]);
                int twoRight = Integer.parseInt(twoArr[1]);
                if (oneLeft < twoLeft) {
                    return -1;
                }
                if (oneLeft > twoLeft) {
                    return 1;
                }
                return oneRight - twoRight;
            }
        });
        System.out.println(res);
        System.out.println(res.size());
    }

}
