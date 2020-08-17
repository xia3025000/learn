package leetcode.dp;

import java.util.Arrays;

public class Leetcode213 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int one = robOne(Arrays.copyOfRange(nums, 0, n - 1));
        int two = robOne(Arrays.copyOfRange(nums, 1, n));
        return Math.max(one, two);
    }

    private int robOne(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <  nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Leetcode213 leetcode213 = new Leetcode213();
        int[] nums = {1, 3, 4};
        int res = leetcode213.rob(nums);
        System.out.println(res);
    }

}
