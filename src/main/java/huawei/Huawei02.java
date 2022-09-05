package huawei;

import java.util.Scanner;

/**

 搜索矩阵
 **题目描述：**实现一个程序 search_matrix(matrix), 参数 matrix 是一个仅包含 0 或 1 两种数字的矩阵,
 程序应返回输入矩阵中包含的最大正方形子矩阵(长和宽相等)的区域面积。
 例如 : 如果 matrix 是[“1010111111”, “000000011”, “1010110111”, “0000110001”, 那么它看起来像下面的阵:
 1010111111
 0000000111
 1010110111
 0000110001
 对于上面的输入, 最大的子矩阵是一个 3x3 的矩阵, 程序只要返回最大子矩阵的面积即可, 如上面的矩阵即返回 9(3x3)。
 输入描述 : 第 1 行输入为一个数字 N, 代表下面有几行
 第 2 行到第 N + 1 行是代表矩阵的 0 和 1 组成的字符串, 每行的长度相同
 输出描述 :
 返回一个数字, 代表输入矩阵的最大正方子矩阵的面积。
 示例 1
 输入
 3
 110
 111
 110
 输出
 4

 */
public class Huawei02 {

    public static int search(char[][] chars) {
        int max = 0;
        int num = chars.length;
        int length = chars[0].length;
        int[][] dp = new int[num][length];
        for (int i = 0; i < num; i++) {
            if (chars[i][0] == '1') {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < length; j++) {
            if (chars[0][j] == '1') {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < num; i++) {
            for (int j = 1; j < length; j++) {
                if (chars[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }

                if (chars[i - 1][j - 1] == '0' || chars[i][j - 1] == '0' || chars[i - 1][j] == '0') {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 0) {
            System.out.println(0);
            return;
        }
        in.nextLine();
        String firstLine = in.nextLine();
        int length = firstLine.length();
        char[][] chars = new char[num][length];
        for (int j = 0; j < length; j++) {
            chars[0][j] = firstLine.charAt(j);
        }
        for (int i = 1; i < num; i++) {
            String s = in.nextLine();
            for (int j = 0; j < length; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        int result = search(chars);
        System.out.println(result);
    }

}
