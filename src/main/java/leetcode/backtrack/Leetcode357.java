package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Leetcode357 {

    int count = 0;
    List<Integer> res = new ArrayList<>();
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        boolean[] visited = new boolean[10];
        Stack<Integer> stack = new Stack<>();
        backtrack(n, visited, stack,0, null);
        System.out.println(res);
        System.out.println(res.size());
        Collections.sort(res);
        System.out.println(res);
        List<Integer> ex = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (!res.contains(i)) {
                ex.add(i);
            }
        }
        System.out.println(ex);
        return count;
    }

    private void backtrack(int n, boolean[] visited, Stack<Integer> stack, int depth, Integer first) {
        if (depth < n) {
            for (int i = 0; i <= 9; i++) {
                if (visited[i] || (first != null && first == 0)) {
                    continue;
                }
                if (first == null) {
                    first = i;
                }
                visited[i] = true;
                count++;
                stack.push(i);
                int sum = 0;
                List<Integer> list = new ArrayList<>(stack);
                for (int j = 0; j <= depth; j++) {
                    sum = sum * 10 + list.get(j);
                }
                res.add(sum);
                backtrack(n, visited, stack, depth + 1, first);
                visited[i] = false;
                stack.pop();
                first = null;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode357 leetcode357 = new Leetcode357();
        int num = leetcode357.countNumbersWithUniqueDigits(3);
        System.out.println(num);
    }

}
