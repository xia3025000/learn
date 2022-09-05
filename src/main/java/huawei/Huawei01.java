package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**

 题目描述：
 小王手里有点闲钱，想着做点卖水果的小买卖。给出两个数组m、n，用m[i]代表第i个水果的成本价，n[i]代表第i水果能卖出的价钱，假如现在有本钱k，试问最后最多能赚多少钱？

 说明：
 1 每种水果只需买一次，只能卖一次
 2 数组m、n大小不超过50
 3 数组元素为正整数，不超过1000

 输入描述：
 1 数组m、n
 2 本钱k
 备注：
 1 首行输入逗号分隔的数组m的元素值
 2 第二行输入逗号分隔的数组n的元素值
 3 第三行输入本钱

 输出描述：
 最多能赚取多少钱。

 示例1
 输入
 4,2,6,4
 5,3,8,7
 15
 输出
 22

 说明
 样例计算过程：
 先买前3种水果，全部卖出，再买第4种水果，再卖出，最后本金变为22。


 */
public class Huawei01 {
    static class B implements Comparable<B> {
        int m;
        int n;
        B(int m, int n) {
            this.m = m;
            this.n = n;
        }
        @Override
        public int compareTo(B o) {
            if(m > o.m) {
                return 1;
            }
            if(m < o.m) {
                return -1;
            }
            if(n > o.n) {
                return -1;
            }
            if(n < o.n) {
                return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String [] mm = in.nextLine().split(",");
        String [] nn = in.nextLine().split(",");
        int k = in.nextInt();
        B [] b = new B [mm.length];
        for(int i = 0; i < b.length; i ++) {
            b[i] = new B(Integer.parseInt(mm[i]), Integer.parseInt(nn[i]));
        }
        mm = null;
        nn = null;
        Arrays.sort(b);
        for(int i = 0; i < b.length; i ++) {
            if(k >= b[i].m && b[i].n > b[i].m) {
                k += (b[i].n - b[i].m);
            }
        }
        System.out.print(k);
        in.close();

    }

}
