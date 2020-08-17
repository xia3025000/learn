package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrack(res, s, stack, 0);
        return res;
    }

    private void backtrack(List<String> res, String s, Stack<String> stack, int start) {
        if (stack.size() <= 4) {
            if (start == s.length() && stack.size() == 4) {
                List<String> list = new ArrayList<>(stack);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i)).append(".");
                }
                sb.append(list.get(list.size() - 1));
                res.add(sb.toString());
                return;
            }
            for (int i = start; i < start + 3 && i < s.length(); i++) {
                String str = s.substring(start, i + 1);
                int num = Integer.parseInt(str);
                if (num > 255) {
                    break;
                }
                stack.push(str);
                backtrack(res, s, stack, i + 1);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        List<String> list = leetcode93.restoreIpAddresses("25525511135");
        System.out.println(list);
    }

}
