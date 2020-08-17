package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Leetcode264 {

    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int count = 6;
        int num = 7;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        while (true) {
            int temp = num;
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                while (temp % list.get(i) == 0) {
                    temp = temp / list.get(i);
                }
            }
            if (temp == 1) {
                count++;
                list.add(num);
                if (count == n) {
                    break;
                }
            }
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        Leetcode264 leetcode264 = new Leetcode264();
        long start = System.currentTimeMillis();
        int res = leetcode264.nthUglyNumber(1690);
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - start);
    }

}
