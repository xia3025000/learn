package algs.bigNum;

public class BigNumAdd {

    public String bigNumAdd(String str1, String str2) {
        String res = "";
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        //carry 进位
        int carry = 0;
        int curr = 0;

        while (i >= 0 && j >= 0) {
            int sum = str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry;
            carry = sum / 10;
            curr = sum % 10;
            res = curr + res;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = str1.charAt(i) - '0' + carry;
            carry = sum / 10;
            curr = sum % 10;
            res = curr + res;
            i--;
        }

        while (j >= 0) {
            int sum = str2.charAt(j) - '0' + carry;
            carry = sum / 10;
            curr = sum % 10;
            res = curr + res;
            j--;
        }

        if (carry > 0) {
            res = carry + res;
        }

        return res;
    }

    public static void main(String[] args) {
        BigNumAdd bigNumAdd = new BigNumAdd();
        String res = bigNumAdd.bigNumAdd("3578349573493767", "3458342975984357");
        System.out.println(res);
    }
}
