package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        backtrack(res, nums, visited, stack);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] visited, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }
            stack.push(nums[i]);
            visited[i] = true;
            backtrack(res, nums, visited, stack);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Leetcode47 leetcode47 = new Leetcode47();
        leetcode47.permuteUnique(new int[]{1, 2, 2});
    }

}
