package leetcode.dp;

public class Leetcode64 {

//    public int minPathSum(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] minPath = new int[n][m];
//        minPath[0][0] = grid[0][0];
//        for (int i = 1; i < m; i++) {
//            minPath[0][i] = grid[0][i] + minPath[0][i - 1];
//        }
//        for (int j = 1; j < n; j++) {
//            minPath[j][0] = grid[j][0] + minPath[j - 1][0];
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                minPath[i][j] = grid[i][j] + Math.min(minPath[i][j - 1], minPath[i - 1][j]);
//            }
//        }
//        return minPath[n - 1][m - 1];
//    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Leetcode64 leetcode64 = new Leetcode64();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int res = leetcode64.minPathSum(grid);
        System.out.println(res);
    }

}
