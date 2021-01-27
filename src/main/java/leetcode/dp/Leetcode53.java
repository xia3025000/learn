package leetcode.dp;

public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            max = Math.max(max, nums[i]);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j + i <= n; j++) {
                dp[j][j + i - 1] = Math.max(dp[j][j + i - 2] + nums[j + i - 1], dp[j + 1][j + i - 1] + nums[j]);
                max = Math.max(max, dp[j][j + i - 1]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] nums = new int[]{1, 2};
        System.out.println(leetcode53.maxSubArray(nums));
    }

}
