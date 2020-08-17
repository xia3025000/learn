package com.xms.learn01;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        ArrayList<Integer> arrayList = new ArrayList<>(linkedList);
        System.out.println(arrayList);

        TestLinkedList testLinkedList = new TestLinkedList();
        Integer i = 3;
        testLinkedList.test01(i);
        System.out.println(i);

    }

    private void test01(Integer i) {
        i = 5;
    }

}
