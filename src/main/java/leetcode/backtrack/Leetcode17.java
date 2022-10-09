package leetcode.backtrack;

import java.util.*;

public class Leetcode17 {

//    public List<String> letterCombinations(String digits) {
//        Map<String, List<String>> map = new HashMap<>();
//        map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
//        map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
//        map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
//        map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
//        map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
//        map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
//        map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
//        map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
//        List<String> res = new ArrayList<>();
//        Stack<String> stack = new Stack<>();
//        backtrack(res, digits, digits.length(), map, stack, 0);
//        return res;
//    }
//
//    private void backtrack(List<String> res, String digits, int n, Map<String, List<String>> map, Stack<String> stack, int depth) {
//        if (depth == n) {
//            List<String> list = new ArrayList<>(stack);
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < list.size(); i++) {
//                sb.append(list.get(i));
//            }
//            res.add(sb.toString());
//            return;
//        }
//        List<String> list = map.get(digits.substring(depth, depth + 1));
//        for (int i = 0; i < list.size(); i++) {
//            stack.push(list.get(i));
//            backtrack(res, digits, n, map, stack, depth + 1);
//            stack.pop();
//        }
//    }


    Map<String, List<String>> map = new HashMap<>();
    {
        map.put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        LinkedList<String> queue = new LinkedList<>();
        backtrack(res, digits, queue, 0);
        return res;

    }

    private void backtrack(List<String> res, String digits, LinkedList<String> queue, int start) {
        if (digits.length() == queue.size()) {
            StringBuilder sb = new StringBuilder();
            List<String> oneRes = new ArrayList<>(queue);
            for (int i = 0; i < oneRes.size(); i++) {
                sb.append(oneRes.get(i));
            }
            res.add(sb.toString());
        }

        if (start == digits.length()) {
            return;
        }

        List<String> valueList = map.get(digits.substring(start, start + 1));
        for (int i = 0; i < valueList.size(); i++) {
            queue.addLast(valueList.get(i));
            backtrack(res, digits, queue, start + 1);
            queue.pollLast();
        }
    }

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        System.out.println(leetcode17.letterCombinations("23"));
    }

}
