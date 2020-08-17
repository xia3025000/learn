package leetcode.other;

public class Leetcode43 {

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int sum = (chars1[i] - '0') * (chars2[j] - '0');
                int low = sum % 10;
                int high = sum / 10;
                res[i + j + 1] = res[i + j + 1] + low;
                res[i + j] = res[i + j] + high;
            }
        }
        for (int i = res.length - 1; i > 0; i--) {
            int temp = res[i];
            res[i] = res[i] % 10;
            res[i - 1] = res[i - 1] + temp / 10;
        }
        StringBuilder sb = new StringBuilder();
        if (res[0] != 0) {
            sb.append(res[0]);
        }
        for (int i = 1; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode43 leetcode43 = new Leetcode43();
        String res = leetcode43.multiply("123", "456");
        System.out.println(res);
    }

}
