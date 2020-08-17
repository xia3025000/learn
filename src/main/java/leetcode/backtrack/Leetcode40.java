package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backtrack(res, candidates, target, stack, 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, Stack<Integer> stack, int currSum, int start) {
        if (currSum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (currSum + candidates[i] > target) {
                continue;
            }
            currSum = currSum + candidates[i];
            stack.push(candidates[i]);
            backtrack(res, candidates, target, stack, currSum, i + 1);
            stack.pop();
            currSum = currSum - candidates[i];
        }
    }

    public static void main(String[] args) {
        Leetcode40 leetcode40 = new Leetcode40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = leetcode40.combinationSum2(candidates, target);
        System.out.println(res);
    }

}
