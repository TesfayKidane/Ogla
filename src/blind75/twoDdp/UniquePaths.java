package blind75.twoDdp;

import java.util.Arrays;

public class UniquePaths {
    // Solution 1: Brut Force with DFS (recursion)
    public int uniquePaths(int c, int r) {
        if (c == 1 || r == 1) return 1;
        return uniquePaths(c -1, r) + uniquePaths(c, r - 1);
    }


    // Solution 2: DP
    // Time : O(N*M)
    // Space : O(N*M)
    public int uniquePaths2(int rows, int columns) {
        int[][] dp = new int[rows][columns];

        for(int[] a : dp) {
            Arrays.fill(a, 1);
        }

        for(int r = 1; r < rows; r++)
            for(int c = 1; c < columns; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }

        return dp[rows-1][columns-1];
    }
}
