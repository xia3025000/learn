package leetcode.backtrack;

public class Leetcode37 {

//    //某行是否置了某数
//    private boolean[][] rowVisited = new boolean[9][10];
//    //某列是否置了某数
//    boolean[][] colVisited = new boolean[9][10];
//    //某box是否置了某数
//    boolean[][] boxVisited = new boolean[9][10];
//
//    public void solveSudoku(char[][] board) {
//        //构建3个boolean数组
//        //行
//        for (int i = 0; i < 9; i++) {
//            //列
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.') {
//                    int n = board[i][j] - '0';
//                    int bn = (i / 3) * 3 + j / 3;
//                    rowVisited[i][n] = true;
//                    colVisited[j][n] = true;
//                    boxVisited[bn][n] = true;
//                }
//            }
//        }
//        backtrack(board, 0, 0);
//    }
//
//    //x 行, y 列
//    private boolean backtrack(char[][] board, int x, int y) {
//        if (y == 9) {
//            return true;
//        }
//        int nx = (x + 1) % 9;
//        int ny = (x + 1) > 8 ? y + 1 : y;
//
//        if (board[y][x] != '.') {
//            return backtrack(board, nx, ny);
//        }
//
//        int boxN = y / 3 * 3 + x / 3;
//
//        for (int i = 1; i <= 9; i++) {
//            if (!rowVisited[y][i] && !colVisited[x][i] && !boxVisited[boxN][i]) {
//                rowVisited[y][i] = true;
//                colVisited[x][i] = true;
//                boxVisited[boxN][i] = true;
//                board[y][x] = (char)(i + '0');
//                if (backtrack(board, nx, ny)) {
//                    return true;
//                }
//                rowVisited[y][i] = false;
//                colVisited[x][i] = false;
//                boxVisited[boxN][i] = false;
//                board[y][x] = '.';
//            }
//        }
//        return false;
//    }

    int count = 0;

    public void solveSudoku(char[][] board) {
        boolean[][] xVisited = new boolean[9][10];
        boolean[][] yVisited = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = (int) (c - '0');
                    xVisited[i][num] = true;
                    yVisited[j][num] = true;
                    int blockNum = i / 3 * 3 + j / 3;
                    block[blockNum][num] = true;
                }
            }
        }
        backtrack(board, xVisited, yVisited, block, 0, 0);
    }

    private boolean backtrack(char[][] board, boolean[][] xVisited, boolean[][] yVisited, boolean[][] block, int x, int y) {
        count++;
        if (x == 9) {
            return true;
        }
        int nextX = (y == 8) ? x + 1 : x;
        int nextY = (y == 8) ? 0 : y + 1;
        if (board[x][y] == '.') {
            int blockNum = x / 3 * 3 + y / 3;
            for (int i = 1; i <= 9; i++) {
                if (!xVisited[x][i] && !yVisited[y][i] && !block[blockNum][i]) {
                    board[x][y] = (char) ('0' + i);
                    xVisited[x][i] = true;
                    yVisited[y][i] = true;
                    block[blockNum][i] = true;
                    if (backtrack(board, xVisited, yVisited, block, nextX, nextY)) {
                        return true;
                    }
                    xVisited[x][i] = false;
                    yVisited[y][i] = false;
                    block[blockNum][i] = false;
                    board[x][y] = '.';
                }
            }
        } else {
            return backtrack(board, xVisited, yVisited, block, nextX, nextY);
        }
        return false;
    }


    public static void main(String[] args) {
        Leetcode37 leetcode37 = new Leetcode37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        leetcode37.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println(leetcode37.count);
//        System.out.println(board);
    }

}
