package leetcode.dp;

public class Leetcode312 {

    int[][] dp;
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int res = getSubMaxCoins(nums, 0, nums.length - 1);
        return res;
    }

    private int getSubMaxCoins(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start == end) {
            int left = start - 1 < 0 ? 1 : nums[start - 1];
            int right = end + 1 > nums.length - 1 ? 1 : nums[end + 1];
            return left * nums[start] * right;
        }
        int max = 0;
        for (int i = start; i <= end; i++) {
            int leftPart = getSubMaxCoins(nums, start, i - 1);
            int rightPart = getSubMaxCoins(nums, i + 1, end);
            int left = start - 1 < 0 ? 1 : nums[start - 1];
            int right = end + 1 > nums.length - 1 ? 1 : nums[end + 1];
            int curr = leftPart + left * nums[i] * right + rightPart;
            max = Math.max(max, curr);
        }
        dp[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        Leetcode312 leetcode312 = new Leetcode312();
        int[] nums = {3, 1, 5, 8};
        int res = leetcode312.maxCoins(nums);
        System.out.println(res);
    }

}
