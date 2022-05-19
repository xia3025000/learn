package algs.bigNum;

public class BigNumMul {

    public String bigNumMul(String str1, String str2) {
        String res = "";
        int[] resArr = new int[str1.length() + str2.length()];

        for (int i = str1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = str2.length() - 1; j >= 0; j--) {
                int sum = (str1.charAt(i) - '0') * (str2.charAt(j) - '0') + resArr[i + j + 1];
                resArr[i + j + 1] = sum % 10;
                carry = sum / 10;
                resArr[i + j] = resArr[i + j] + carry;
            }
        }

        int start = -1;
        for (int i = 0; i < resArr.length; i++) {
            if (resArr[i] != 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            for (int i = 0; i < resArr.length; i++) {
                res = res + resArr[i];
            }
        } else {
            for (int i = start; i < resArr.length; i++) {
                res = res + resArr[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BigNumMul bigNumMul = new BigNumMul();
        String res = bigNumMul.bigNumMul("3578349573493767", "3458342975984357");
//        String res = bigNumMul.bigNumMul("3578349573493767", "1");
//        String res2 = bigNumMul.bigNumMul("3578349573493767", "11");
        System.out.println(res);
//        System.out.println(res2);
    }

}
