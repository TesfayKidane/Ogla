package blind75.oneDdp;

import java.util.HashMap;
import java.util.Map;

/** 322. Coin Change - Medium
You are given an integer array coins representing coins of different denominations and an integer
amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 **/
public class CoinChanges {
    // Solution 1 [Correct, Time Exceeded]
    public int coinChange1(int[] coins, int amount) {
        return recursion(coins, amount);
    }
    private int recursion(int[] coins, int remain) {
        if(remain < 0) return -1;
        if(remain == 0) return 0;

        int minCount = Integer.MAX_VALUE;
        for(int coin : coins) {
            int count = recursion(coins, remain - coin);
            if(count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    // Solution 2:
    // Time = O(S * N), where S = Amount and N is number of coins
    // Space = O(S), where S = Amount and N is number of coins
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChang2(int[] coins, int amount) {
        return recursionWithMemo(coins, amount);
    }

    private int recursionWithMemo(int[] coins, int amount) {
        if(memo.containsKey(amount)) return memo.get(amount);
        if(amount < 0) return -1;
        if(amount == 0) return 0;

        int minCount = Integer.MAX_VALUE;
        for(int coin : coins) {
            int count = recursionWithMemo(coins, amount - coin);
            if(count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }

        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        memo.put(amount, minCount);
        return minCount;
    }

}
