package com.xms.learn01;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(3));
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.remove(new Integer(2));//取决于删除的是对象还是int数字
        System.out.println(list);
    }

}
