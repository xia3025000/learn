package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        //下一层j = min(上一层j - 1,j)
        //dp[i][j] = min(dp[i][j - 1], dp[i][j])
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                } else if (j == i) {
                    dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] < min) {
                min = dp[n - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Leetcode120 leetcode120 = new Leetcode120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        int res = leetcode120.minimumTotal(triangle);
        System.out.println(res);
    }

}
