package com.xms.learn01;

public class TestAssert {

    public static void main(String[] args) {
        boolean isSafe = false;
        assert isSafe : "Not pass";
        System.out.println("断言通过!");
    }

}
