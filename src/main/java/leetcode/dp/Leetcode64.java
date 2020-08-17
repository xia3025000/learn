package leetcode.dp;

public class Leetcode64 {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] minPath = new int[n][m];
        minPath[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            minPath[0][i] = grid[0][i] + minPath[0][i - 1];
        }
        for (int j = 1; j < n; j++) {
            minPath[j][0] = grid[j][0] + minPath[j - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                minPath[i][j] = grid[i][j] + Math.min(minPath[i][j - 1], minPath[i - 1][j]);
            }
        }
        return minPath[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Leetcode64 leetcode64 = new Leetcode64();
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        int res = leetcode64.minPathSum(grid);
        System.out.println(res);
    }

}
