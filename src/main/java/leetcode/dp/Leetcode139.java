package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, 0);
    }

    private boolean backtrack(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains((s.substring(i + 1)))) {
                return true;
            }
            if (wordDict.contains(s.substring(start, i + 1))) {
                wordDict.add(s.substring(0, i + 1));
                if (backtrack(s, wordDict, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode139 leetcode139 = new Leetcode139();
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        boolean res = leetcode139.wordBreak(s, wordDict);
        System.out.println(res);
    }

}
