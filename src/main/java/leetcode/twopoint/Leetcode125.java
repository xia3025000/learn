package leetcode.twopoint;

public class Leetcode125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            char c = chars[left];
            char d = chars[right];
            if (c <= 'z' && c >= 'a') {

            } else if (c <= 'Z' && c >= 'A') {
                c = (char) (32 + (int) c);
            } else if (c <= '9' && c >= '0') {

            } else {
                left++;
                continue;
            }

            if (d <= 'z' && d >= 'a') {

            } else if (d <= 'Z' && d >= 'A') {
                d = (char) (32 + (int) d);
            } else if (d <= '9' && d >= '0') {

            } else {
                right--;
                continue;
            }
            if (c != d) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode125 leetcode125 = new Leetcode125();
        String s = "A man, a plan, a canal: Panama";
        boolean res = leetcode125.isPalindrome(s);
        System.out.println(res);
    }
}
