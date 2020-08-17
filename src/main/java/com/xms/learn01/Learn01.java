package com.xms.learn01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Learn01 {

    public static void main(String[] args) {
//        String[][] str = new String[3][3];
//        System.out.println(str[1][1]);
        int x = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(x);
    }

    public static void test01() {
        StringBuilder sb = new StringBuilder();
        String maxStr = "";
        String s = "abcd";
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        char[] sArr = s.toCharArray();
        for (int i = 0, j = 0; j < n; j++) {
            String oneStr = String.valueOf(sArr[j]);
            if (!map.containsKey(oneStr)) {
                map.put(oneStr, j);
                sb.append(oneStr);
                if (sb.length() > maxStr.length()) {
                    maxStr = sb.toString();
                }
            } else {
                i = Math.max(map.get(oneStr) + 1, i);
                sb = new StringBuilder(s.substring(i, j + 1));
            }
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        String maxStr = "";
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        char[] sArr = s.toCharArray();
        for (int i = 0, j = 0; j < n; j++) {
            String oneStr = String.valueOf(sArr[j]);
            if (!map.containsKey(oneStr)) {
                sb.append(oneStr);
            } else {
                i = Math.max(map.get(oneStr) + 1, i);
                sb = new StringBuilder(s.substring(i, j + 1));
            }
            if (sb.length() > maxStr.length()) {
                maxStr = sb.toString();
            }
            map.put(oneStr, j);
        }
        return maxStr.length();
    }

}
