package blind75.oneDdp;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    //Solution 1: Brute Force
    //Time = O(2^n) where n is the length of the string
    //Space = O(n), the depth of the recursion can go up to the length of n.
    public boolean wordBreak1(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, HashSet<String> wordDict, int start) {
        if (start == s.length()) return true;

        for(int end = start + 1; end <= s.length(); end++) {
            if(wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }


    // Solution 2: Recursion with Memo
    // Time : O(n^3) where n is the length of the string.
    // Space: O(n), the depth of the recursion can go up to the length of the string.

    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreakRecurWithMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakRecurWithMemo(String s, HashSet<String> wordDict, int start, Boolean[] memo) {
        if(start == s.length()) return true;

        if(memo[start] != null) return memo[start];

        for(int end = start + 1; end <= s.length(); end++) {
            if(wordDict.contains(s.substring(start, end)) && wordBreakRecurWithMemo(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }
}
