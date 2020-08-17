package com.xms.learn01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        System.out.println(list);
    }
}
