package leetcode.dp;

public class Leetcode5 {

    public String longestPalindrome(String s) {
        //斜着遍历法
        int n = s.length();
        if (n == 0 || n == 1) {
            return s.substring(0, n);
        }

        int start = 0;
        int end = 0;

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //k表示子串长度
        for (int k = 2; k <= n; k++) {
            //i + k - 1表示子串尾节点
            for (int i = 0; i + k - 1 < n; i++) {
                if (chars[i] == chars[i + k - 1]) {
                    if (k == 2) {
                        dp[i][i + k - 1] = true;
                        start = i;
                        end = i + k - 1;
                    } else {
                        if (dp[i + 1][i + k - 2]) {
                            dp[i][i + k - 1] = true;
                            start = i;
                            end = i + k - 1;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        String res = leetcode5.longestPalindrome("aacabdkacaa");
        System.out.println(res);
    }

}
