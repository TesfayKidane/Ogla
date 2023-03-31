package blind75.twoDdp;

import java.util.Arrays;

public class LongestCommonSubString {

    // Solution 1: DP

    public int lengthOfLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int[] a : dp) {
            Arrays.fill(a, 0);
        }

        for(int r = 1; r <= s1.length(); r++) {
            for(int c = 1; c <= s2.length(); c++) {
                if(s1.charAt(r-1) == s2.charAt(c-1)) {
                    if(c-1 >= 0 && r-1 >= 0) {
                        dp[r][c] = dp[r-1][c-1] + 1;
                    } else {
                        dp[r][c] = 1;
                    }
                } else {
                    if(c-1 >= 0 && r-1 >= 0) {
                        dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                    } else {
                        dp[r][c] = 1;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
