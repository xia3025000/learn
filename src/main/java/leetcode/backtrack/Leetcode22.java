package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrack(res, n, stack, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, int n, Stack<String> stack, int leftNum, int rightNum) {
        if (rightNum == n) {
            StringBuilder sb = new StringBuilder();
            List<String> oneRes = new ArrayList<>(stack);
            for (int i = 0; i < 2 * n; i++) {
                sb.append(oneRes.get(i));
            }
            res.add(sb.toString());
            return;
        }

        if (leftNum < n) {
            stack.push("(");
            backtrack(res, n, stack, leftNum + 1, rightNum);
            stack.pop();
        }

        if (rightNum < leftNum) {
            stack.push(")");
            backtrack(res, n, stack, leftNum, rightNum + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        System.out.println(leetcode22.generateParenthesis(3));
    }

}
