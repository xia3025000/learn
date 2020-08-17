package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrack(res, s, stack, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, String s, Stack<String> stack, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (!isPalindrome(str)) {
                continue;
            }
            stack.push(str);
            backtrack(res, s, stack, i + 1);
            stack.pop();
        }
    }

    private boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i <= n / 2 - 1; i++) {
            if (chars[i] != chars[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode131 leetcode131 = new Leetcode131();
        List<List<String>> res = leetcode131.partition("aab");
        System.out.println(res);
    }

}
