package algs.bigNum;

public class BigNumSub {

    public String bigNumSub(String str1, String str2) {
        String tempRes = "";
        String res = "";
        //判断str1和str2哪个字符串更长
        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        } else if (str1.length() == str2.length()) {
            int i = 0;
            int j = 0;
            while (i <str1.length() && j < str2.length()) {
                int up = str1.charAt(i) - '0';
                int down = str2.charAt(j) - '0';
                if (up > down) {
                    break;
                } else if (up < down) {
                    String temp = str1;
                    str1 = str2;
                    str2 = temp;
                    break;
                }
                i++;
                j++;
            }
        }

        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int borrow = 0;
        int curr = 0;

        while (i >= 0 || j >= 0) {
            int sub = 0;
            int up = str1.charAt(i) - '0';
            int down = j >= 0 ? str2.charAt(j) - '0' : 0;
            sub = up - down - borrow + 10;
            curr = sub % 10;
            borrow = up - down - borrow >= 0 ? 0 : 1;
            tempRes = curr + tempRes;
            i--;
            j--;
        }

        int maxLen = tempRes.length();
        int k = 0;
        int start = -1;
        while (k <= maxLen - 1) {
            if (tempRes.charAt(k) != '0') {
                start = k;
                break;
            }
            k++;
        }

        if (start == -1) {
            res = "0";
        } else {
            res = tempRes.substring(start);
        }

        return res;
    }

    public static void main(String[] args) {
        BigNumSub bigNumSub = new BigNumSub();
        String res = bigNumSub.bigNumSub("3578349573493767", "3458342975984357");
//        String res = bigNumSub.bigNumSub("1000", "110");
        System.out.println(res);
    }
}
