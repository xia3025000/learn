package leetcode.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int n = s.length();
        //确定dp，哪些是可以分割的回文串
        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j] && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        dfs(res, stack, s, 0, n, dp);
        return res;
    }

    private void dfs(List<List<String>> res, Stack<String> stack, String s, int start, int n, boolean[][] dp) {
        if (start == n) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                stack.push(s.substring(start, i + 1));
                dfs(res, stack, s, i + 1, n, dp);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Leetcode131 leetcode131 = new Leetcode131();
        List<List<String>> res = leetcode131.partition("aab");
        System.out.println(res);
    }
}
