package leetcode.dp;

public class Leetcode877 {

    public boolean stoneGame(int[] piles) {
        //dp[i][j].fir = Math.max(piles[i] + dp[i + 1][j].sec, piles[j] + dp[i][j - 1].sec);
        //dp[i][j].sec = dp[i + 1][j] 或 dp[i][j - 1];
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        //j - i = L, L代表横轴与纵轴差距
        for (int L = 1; L <= n - 1; L++) {
            for (int j = L; j < n; j++) {
                int i = j - L;
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left < right) {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                } else {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                }
            }
        }

        return dp[0][n - 1].fir > dp[0][n - 1].sec;
    }

    class Pair {
        int fir;
        int sec;
        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    public static void main(String[] args) {
        Leetcode877 leetcode877 = new Leetcode877();
        int[] piles = {5, 3, 4, 5};
        boolean res = leetcode877.stoneGame(piles);
        System.out.println(res);
    }

}
