package leetcode.backtrack;

public class Leetcode306 {

    public boolean isAdditiveNumber(String num) {
        //找前3个
        for (int i = 1; i <= num.length() / 2; i++) {
            int first = Integer.parseInt(num.substring(0, i));
            for (int j = i; j < num.length() / 3 * 2; j++) {
                int second = Integer.parseInt(num.substring(i, j + 1));
                int sum = first + second;
                for (int k = j + 2; k <= num.length(); k++) {
                    int third = Integer.parseInt(num.substring(j + 1, k));
                    if (sum == third) {
                        if (k == num.length()) {
                            return true;
                        }
                        return backtrack(num, second, third, k);
                    }
                }

            }
        }
        return false;
    }

    private boolean backtrack(String num, int x, int y, int start) {
        if (x + y == Integer.parseInt(num.substring(start, num.length()))) {
            return true;
        }
        for (int i = start; i < num.length(); i++) {
            int sum = x + y;
            String str = String.valueOf(sum);
            if (str.length() > num.length() - start) {
                break;
            }
            if (str.length() == num.length() - start) {
                if (!str.equals(num.substring(start, num.length()))) {
                    break;
                }
            }
            if (str.length() < i + 1 - start) {
                continue;
            }
            if (backtrack(num, y, sum, i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode306 leetcode306 = new Leetcode306();
        boolean trueOrFalse = leetcode306.isAdditiveNumber("1203");
        System.out.println(trueOrFalse);
    }

}
