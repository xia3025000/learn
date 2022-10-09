package com.xms.learn01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {

    public static void main(String[] args) {
//        PriorityQueue<Integer> smallQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();

        smallQueue.add(3);
        smallQueue.add(2);
        smallQueue.add(1);
        System.out.println(smallQueue.poll());
        System.out.println(smallQueue.poll());
        System.out.println(smallQueue.poll());
    }

}
