package com.xms.learn01;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 6, 3, 7, 2};
        //return > 0 则表示按索引从小到大
        //o1表示后面,o2表示前面
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1 + " " + o2);
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

//        int[][] envelopes = new int[10][2];
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });
    }

}
