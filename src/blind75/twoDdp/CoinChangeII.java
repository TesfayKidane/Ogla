package blind75.twoDdp;

import java.util.*;

/*
518. Coin Change 2

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.
Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 */
public class CoinChangeII {
    int coinChange2(int[] coins, int amount) {
        // starting from every element in the coin, check if the given amount can be built.
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> miniResult = new ArrayList<>();
        for(int i = 0; i < coins.length; i++) {
            dp(coins, i, amount, miniResult, result);
        }
        return result.size();
    }

    private void dp(int[] coins, int i, int remain, List<Integer> miniResult, Set<List<Integer>> result) {

        // if remaining is 0, it means the target will achieved using the coins selected
        if(remain == 0 && !miniResult.isEmpty()) {
            Collections.sort(miniResult);
            result.add(new ArrayList<>(miniResult));
           /* System.out.println();
            for (Integer a : miniResult) {
                System.out.print(a + ", ");
            }*/
            miniResult.clear();
            return;
        }

        // if remaining amount is below zero, it means we can't achieve by selecting this coins.
        if(remain < 0) {
            miniResult.clear();
            return;
        }

        miniResult.add(coins[i]);
        for(int j = 0; j < coins.length; j++) {
            dp(coins, j, remain - coins[j], miniResult, result);
        }
    }

    public static void main(String[] args) {
        CoinChangeII ccII = new CoinChangeII();
        int[] input = {1, 2, 3};
        ccII.coinChange2(input, 5);
    }
}
