package leetcode.backtrack;

public class Leetcode79 {

    public boolean exist(char[][] board, String word) {
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, direction, visited, i, j, 0)) {
                    return true;
                }
                visited = new boolean[board.length][board[0].length];
            }
        }
        return false;
    }

    //X纵轴,Y横轴
    private boolean dfs(char[][] board, String word, int[][] direction, boolean[][] visited, int x, int y, int depth) {
        if (inArea(x, y, board) && !visited[x][y] && board[x][y] == word.charAt(depth)) {
            if (depth == word.length() - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                //在区内,未被访问,与word相同
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                visited[x][y] = true;
                if (dfs(board, word, direction, visited, newX, newY, depth + 1)) {
                    return true;
                }
                visited[x][y] = false;
            }
        }

        return false;
    }

    private boolean inArea(int i, int j, char[][] board) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        Leetcode79 solution = new Leetcode79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
