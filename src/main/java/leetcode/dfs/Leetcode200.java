package leetcode.dfs;

public class Leetcode200 {

    int[][] find = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            visited[x][y] = true;
            int nextX = x + find[i][0];
            int nextY = y + find[i][1];
            if (nextX < grid.length && nextY < grid[0].length && nextX >= 0 && nextY >=0 && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                dfs(grid, nextX, nextY, visited);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode200 leetcode200 = new Leetcode200();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int res = leetcode200.numIslands(grid);
        System.out.println(res);
    }
}
