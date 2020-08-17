package leetcode.dp;

public class Leetcode221 {

    public int maximalSquare(char[][] matrix) {
        //上正方==左正方
        //当前正方+1=上正方 + (-上正方宽度,-上正方宽度),否则等于上正方宽度
        //上正方>左正方
        //当前正方=左正方+1
        //上正方<左正方
        //当前正方=上正方+1
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(dp[0][j], max);
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (dp[i - 1][j] == 0 || dp[i][j - 1] == 0) {
                        dp[i][j] = 1;
                    } else {
                        int comp = dp[i - 1][j] - dp[i][j - 1];
                        if (comp == 0) {
                            int size = dp[i - 1][j];
                            if (matrix[i - size][j - size] == '1') {
                                dp[i][j] = size + 1;
                            } else {
                                dp[i][j] = size;
                            }
                        } else if (comp > 0) {
                            dp[i][j] = dp[i][j - 1] + 1;
                        } else {
                            dp[i][j] = dp[i - 1][j] + 1;
                        }
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        Leetcode221 leetcode221 = new Leetcode221();
        char[][] matrix = {{'0','0','0','1'},{'1', '1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        int res = leetcode221.maximalSquare(matrix);
        System.out.println(res);
    }

}
