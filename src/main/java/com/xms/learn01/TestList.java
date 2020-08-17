package com.xms.learn01;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.remove(3);
        System.out.println(list);
    }

}
