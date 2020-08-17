package leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class Leetcode60 {

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        int[] factor = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        factor[0] = 1;
        for (int i = 1; i <= n; i++) {
            factor[i] = factor[i - 1] * i;
            list.add(i);
        }

        k = k - 1;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int div = k / factor[n - 1];
            k = k % factor[n - 1];
            int c = list.get(div);
            sb.append(c);
            list.remove(div);
            n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode60 leetcode60 = new Leetcode60();
        System.out.println(leetcode60.getPermutation(3, 3));
    }
}
