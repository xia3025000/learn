package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        backtrack(res, n, 0, visited);
        return res;
    }

    private void backtrack(List<List<String>> res, int n, int i, boolean[][] visited) {
        if (i == n) {
            for (int x = 0; x < n; x++) {
                List<String> line = new ArrayList<>(n);
                for (int y = 0; y < n; y++) {
                    if (visited[x][y]) {
                        line.add("Q");
                    } else {
                        line.add(".");
                    }
                }
                res.add(line);
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            //上面不放置
            int k = i - 1;
            boolean up = true;
            while (k >= 0) {
                if (visited[k][j]) {
                    up = false;
                    break;
                }
                k--;
            }
            if (!up) {
                continue;
            }
            //斜线不放置,即[i-k][j-k],[i-k][j+k]不为true
            k = 1;
            boolean leftUp = true;
            while (i - k >= 0 && j - k >= 0) {
                if (visited[i - k][j - k]) {
                    leftUp = false;
                    break;
                }
                k++;
            }
            if (!leftUp) {
                continue;
            }
            k = 1;
            boolean rightUp = true;
            while (i - k >= 0 && j + k <= n - 1) {
                if (visited[i - k][j + k]) {
                    rightUp = false;
                    break;
                }
                k++;
            }
            if (!rightUp) {
                continue;
            }
            visited[i][j] = true;
            backtrack(res, n, i + 1, visited);
            visited[i][j] = false;
        }
    }

    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        System.out.println(leetcode51.solveNQueens(4));
    }

}
