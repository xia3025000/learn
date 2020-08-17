package leetcode.backtrack;

import java.util.Arrays;

public class Leetcode377 {

    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int currSum) {
        if (currSum == target) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = currSum + nums[i];
            if (temp <= target) {
                backtrack(nums, target, temp);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode377 leetcode377 = new Leetcode377();
        int[] nums = {2, 1, 3};
        int target = 18;
        int res = leetcode377.combinationSum4(nums, target);
        System.out.println(res);
    }

}
