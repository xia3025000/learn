package leetcode.dp;

public class Leetcode123 {

    public int maxProfit(int[] prices) {
        //dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        //dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int[][][] dp = new int[n][3][2];
        int max = 0;
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            for (int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                max = Math.max(dp[i][k][0], max);
            }
        }
        return dp[n - 1][2][0];
    }

    public static void main(String[] args) {
        Leetcode123 leetcode123 = new Leetcode123();
        int[] prices = {1, 2, 3, 4, 5};
        int res = leetcode123.maxProfit(prices);
        System.out.println(res);
    }

}
